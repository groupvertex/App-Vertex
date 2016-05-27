package com.vertex.controller;

import com.vertex.config.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.Entity.WayPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

/**
 * Created by RASTA on 26.05.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest("server.port:8080")
public class RouteControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://localhost:8080/routes";

    private long ROUTE_ID;

    private Route TEST_ROUTE;

    @Before
    public void init() {
        TEST_ROUTE = new Route("test");
        ResponseEntity<Long> entity = restTemplate.postForEntity(URL, TEST_ROUTE, Long.class);
        ROUTE_ID = entity.getBody();
        TEST_ROUTE.setId(ROUTE_ID);
    }

    @After
    public void clear() {
        restTemplate.delete(URL + "/" + ROUTE_ID);
    }

    @Test
    public void createDuplicate() throws Exception {
        Route duplicate = new Route(ROUTE_ID, "test");
        ResponseEntity<Long> dupl = restTemplate.postForEntity(URL, duplicate, Long.class);
        long duplicateId = dupl.getBody();
        assertNotEquals(ROUTE_ID, duplicateId);
        restTemplate.delete(URL + "/" + duplicateId);
    }


    @Test
    public void getExisted() throws Exception {
        Route actual = restTemplate.getForEntity(URL + "/" + ROUTE_ID, Route.class).getBody();
        assertEquals(TEST_ROUTE, actual);
    }

    @Test(expected = HttpClientErrorException.class)
    public void getNotExisted() throws Exception {
        restTemplate.getForEntity(URL + "/" + ThreadLocalRandom.current().nextInt(), Route.class);
    }

    @Test
    public void update() throws Exception {
        TEST_ROUTE.setName("testUpdate");
        List<WayPoint> wayPoints = new ArrayList<>();
        WayPoint first = WayPoint.newBuilder().setId(ThreadLocalRandom.current().nextLong()).setRouteId(ROUTE_ID).setX(1).setY(1).build();
        wayPoints.add(first);
        TEST_ROUTE.setWayPoints(wayPoints);
        restTemplate.put(URL + "/" + ROUTE_ID, TEST_ROUTE);
        wayPoints.add(first);

        TEST_ROUTE.setWayPoints(wayPoints);
        restTemplate.put(URL + "/" + ROUTE_ID, TEST_ROUTE);
        Route actual = restTemplate.getForEntity(URL + "/" + ROUTE_ID, Route.class).getBody();
        assertEquals("testUpdate", actual.getName());
        assertEquals(1, actual.getWayPoints().size());
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteTwice() throws Exception {
        restTemplate.delete(URL + "/" + ROUTE_ID);
        restTemplate.delete(URL + "/" + ROUTE_ID);
        restTemplate.getForEntity(URL + "/" + ROUTE_ID, Route.class).getBody();
    }
}