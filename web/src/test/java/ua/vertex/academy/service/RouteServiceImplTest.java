/*
package ua.vertex.academy.service;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.academy.config.Configuration;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.Entity.WayPoint;

import static org.junit.Assert.*;

*/
/**
 * Created by RASTA on 20.05.2016.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class RouteServiceImplTest {

    @Autowired
    RouteService routeService;

    private static long ROUTE_ID = 1;

    private static Route TEST_ROUTE;


    @Before
    public void init() {
        TEST_ROUTE = new Route(1, "test");
        routeService.create(TEST_ROUTE);
    }

    @After
    public void clear() {
        routeService.delete(ROUTE_ID);
    }

    @Test
    public void createExistedTest() throws Exception {
        Route existed = new Route(ROUTE_ID, "test");
        long existedId = routeService.create(existed);
        assertEquals(-1, existedId);
    }


    @Test
    public void get() throws Exception {
        Route actual = routeService.get(ROUTE_ID + 1);
        assertEquals(TEST_ROUTE, actual);
    }

    @Test()
    public void getNotExisted() throws Exception {
        Route actual = routeService.get(ROUTE_ID + 10);
        assertEquals("empty", actual.getName());
    }

    @Test
    public void update() throws Exception {
        TEST_ROUTE.setName("testUpdate");
        routeService.update(ROUTE_ID, TEST_ROUTE);
        Route actual = routeService.get(ROUTE_ID);
        assertEquals("testUpdate", actual.getName());
    }

    @Test
    public void deleteTwice() throws Exception {
        routeService.delete(ROUTE_ID);
        routeService.delete(ROUTE_ID);
        Route route = routeService.get(ROUTE_ID);
        assertEquals("emptyRoute", route.getName());
    }

    @Test
    public void addWaypoint() throws Exception {
        WayPoint first = new WayPoint((int) ROUTE_ID, 1, 1, 1, 1);
        WayPoint second = new WayPoint((int) ROUTE_ID, 2, 2, 2, 1);
        WayPoint third = new WayPoint((int) ROUTE_ID, 3, 3, 3, 1);
        routeService.addWaypoint(first);
        routeService.addWaypoint(second);
        routeService.addWaypoint(third);
        Route expected = routeService.get(ROUTE_ID);
        assertEquals(3, expected.getWayPoints().size());

        routeService.deleteWayPoint(first.getId());
        routeService.deleteWayPoint(second.getId());
        routeService.deleteWayPoint(third.getId());
    }

    @Test
    public void deleteWayPoint() throws Exception {
        WayPoint first = new WayPoint((int) ROUTE_ID, 1, 1, 1, 1);
        WayPoint second = new WayPoint((int) ROUTE_ID, 2, 2, 2, 1);
        WayPoint third = new WayPoint((int) ROUTE_ID, 3, 3, 3, 1);
        routeService.addWaypoint(first);
        routeService.addWaypoint(second);
        routeService.addWaypoint(third);
        routeService.deleteWayPoint(third.getId());
        Route expected = routeService.get(ROUTE_ID);
        assertEquals(2, expected.getWayPoints().size());

        routeService.deleteWayPoint(first.getId());
        routeService.deleteWayPoint(second.getId());

    }
}*/
