//package ua.vertex.academy.service;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.junit.Test;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import ua.vertex.academy.config.Configuration;
//import ua.vertex.route.Entity.Route;
//import ua.vertex.waypoint.Entity.WayPoint;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.*;
//
///**
// * Created by RASTA on 20.05.2016.
// */
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Configuration.class)
//public class RouteServiceImplTest {
//
//    @Autowired
//    RouteService routeService;
//
//    private static long ROUTE_ID;
//
//    private static Route TEST_ROUTE;
//
//
//    @Before
//    public void init() {
//        TEST_ROUTE = new Route("test");
//        ROUTE_ID = routeService.create(TEST_ROUTE);
//    }
//
//    @After
//    public void clear() {
//        routeService.delete(ROUTE_ID);
//    }
//
//    @Test
//    public void createDuplicate() throws Exception {
//        Route duplicate = new Route(ROUTE_ID, "test");
//        long duplicateId = routeService.create(duplicate);
//        assertNotEquals(ROUTE_ID, duplicateId);
//        routeService.delete(duplicateId);
//    }
//
//    @Test
//    public void createNull() throws Exception {
//        long duplicateId = routeService.create(null);
//        assertEquals(-1, duplicateId);
//    }
//
//    @Test
//    public void getExisted() throws Exception {
//        Route actual = routeService.read(ROUTE_ID);
//        assertEquals(TEST_ROUTE, actual);
//    }
//
//    @Test()
//    public void getNotExisted() throws Exception {
//        Route actual = routeService.read(ROUTE_ID + 10);
//        assertEquals("empty", actual.getName());
//    }
//
//    @Test
//    public void update() throws Exception {
//        TEST_ROUTE.setName("testUpdate");
//
//        List<WayPoint> wayPoints = new ArrayList<>();
//        WayPoint first = WayPoint.newBuilder().setRouteId(ROUTE_ID).setX(1).setY(1).setHeight(1).setAccuracy(1).build();
//        WayPoint second = WayPoint.newBuilder().setRouteId(ROUTE_ID).setX(3).setY(2).setHeight(2).setAccuracy(2).build();
//        WayPoint third = WayPoint.newBuilder().setRouteId(ROUTE_ID).setX(3).setY(3).setHeight(3).setAccuracy(3).build();
//        wayPoints.add(first);
//        wayPoints.add(second);
//        wayPoints.add(third);
//        TEST_ROUTE.setWayPoints(wayPoints);
//        routeService.update(ROUTE_ID, TEST_ROUTE);
//
//
//        wayPoints = new ArrayList<>();
//        wayPoints.add(first);
//
//        TEST_ROUTE.setWayPoints(wayPoints); //// TODO: 21.05.2016 Test once more after change to Set
//        routeService.update(ROUTE_ID, TEST_ROUTE);
//        Route actual = routeService.read(ROUTE_ID);
//        assertEquals("testUpdate", actual.getName());
//        assertEquals(3, actual.getWayPoints().size());
//    }
//
//    @Test
//    public void deleteTwice() throws Exception {
//        routeService.delete(ROUTE_ID);
//        routeService.delete(ROUTE_ID);
//        Route route = routeService.read(ROUTE_ID);
//        assertEquals("empty", route.getName());
//    }
//}
