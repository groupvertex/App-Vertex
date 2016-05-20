package ua.vertex.waypoint.DAO;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.waypoint.config.WayPointConfig;
import ua.vertex.waypoint.Entity.WayPoint;

import static org.junit.Assert.*;

/**
 * Created by Vasyl on 18/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
public class WayPointDAOImplTest {


//    @Autowired
//    private WayPointDAO wayPointDAO;
//
//    @org.junit.Test
//    public void createWayPoint() throws Exception {
//        WayPoint point1 = new WayPoint(3, 45, 67, 400, 5);
//        WayPoint point1New = new WayPoint(3, 111, 111, 111, 1);
//        WayPoint point2 = new WayPoint(3, 67, 98, 400, 5);
//        WayPoint point3 = new WayPoint(1, 105, 34, 400, 5);
//        WayPoint point4 = new WayPoint(3, 425, 97, 400, 12);
//
//        System.out.println("-----------------Create points------------------");
//
//        int p1 = wayPointDAO.createWayPoint(point1);
//        Thread.sleep(1000);
//        int p2 = wayPointDAO.createWayPoint(point2);
//        Thread.sleep(1000);
//        int p4 = wayPointDAO.createWayPoint(point4);
//        Thread.sleep(1000);
//        int p3 = wayPointDAO.createWayPoint(point3);
//        Thread.sleep(1000);
//
//        System.out.println("id =" + wayPointDAO.readWayPoint(p1).getId());
//        System.out.println("track id = " + wayPointDAO.readWayPoint(p1).getRouteId());
//        System.out.println("x = " + wayPointDAO.readWayPoint(p1).getX());
//        System.out.println("y = " + wayPointDAO.readWayPoint(p1).getY());
//        System.out.println("height = " + wayPointDAO.readWayPoint(p1).getHeight());
//        System.out.println("accuracy = " + wayPointDAO.readWayPoint(p1).getAccuracy());
//        System.out.println("add time = " + wayPointDAO.readWayPoint(p1).getAddTime());
//    }
//
//    @Test
//    public void readWayPoint() throws Exception {
//
//    }
//
//    @Test
//    public void updateWayPoint() throws Exception {
//
//    }
//
//    @Test
//    public void deleteWayPoint() throws Exception {
//
//    }
//
//    @Test
//    public void getSortedWayPointsForRoute() throws Exception {
//
//    }

}