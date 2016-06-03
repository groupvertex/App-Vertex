package ua.vertex.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import entity.Route;
import entity.WayPoint;
import ua.vertex.config.WebConfig;
import ua.vertex.exception.RouteNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@ActiveProfiles("test")
public class RouteServiceImplTest {

    @Autowired
    RouteService routeService;

    private long ROUTE_ID;

    private Route TEST_ROUTE;

    @Before
    public void init() {
        TEST_ROUTE = new Route("test");
        ROUTE_ID = routeService.create(TEST_ROUTE);
    }

    @After
    public void clear() {
        routeService.delete(ROUTE_ID);
    }

    @Test
    public void createDuplicate() throws Exception {
        Route duplicate = new Route(ROUTE_ID, "test");
        long duplicateId = routeService.create(duplicate);
        assertNotEquals(ROUTE_ID, duplicateId);
        routeService.delete(duplicateId);
    }

    @Test
    public void createNull() throws Exception {
        long nullId = routeService.create(null);
        assertEquals(-1, nullId);
    }

    @Test
    public void getExisted() throws Exception {
        Route actual = routeService.read(ROUTE_ID);
        assertEquals(TEST_ROUTE, actual);
    }

    @Test(expected = RouteNotFoundException.class)
    public void getNotExisted() throws Exception {
        routeService.read(ROUTE_ID + 10);
    }

    @Test
    public void update() throws Exception {
        TEST_ROUTE.setName("testUpdate");
        List<WayPoint> wayPoints = new ArrayList<>();
        ThreadLocalRandom current = ThreadLocalRandom.current();
        WayPoint first = WayPoint.newBuilder().setId(current.nextLong()).setRouteId(ROUTE_ID).setX(1).setY(1).build();
        WayPoint second = WayPoint.newBuilder().setId(current.nextLong()).setRouteId(ROUTE_ID).setX(3).setY(2).build();
        wayPoints.add(first);
        wayPoints.add(second);
        TEST_ROUTE.setWayPoints(wayPoints);
        routeService.update(ROUTE_ID, TEST_ROUTE);
        wayPoints.add(first);

        TEST_ROUTE.setWayPoints(wayPoints);
        routeService.update(ROUTE_ID, TEST_ROUTE);
        Route actual = routeService.read(ROUTE_ID);
        assertEquals("testUpdate", actual.getName());
        assertEquals(2, actual.getWayPoints().size());
    }

    @Test(expected = RouteNotFoundException.class)
    public void deleteTwice() throws Exception {
        routeService.delete(ROUTE_ID);
        routeService.delete(ROUTE_ID);
        routeService.read(ROUTE_ID);
    }
}
