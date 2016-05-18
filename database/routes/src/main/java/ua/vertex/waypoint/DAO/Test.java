package ua.vertex.waypoint.DAO;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ua.vertex.waypoint.Configuration.Conf;
//import ua.vertex.waypoint.Entity.WayPoint;
//
//import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
//
//        WayPointDAO wayPointDAO = context.getBean(WayPointDAO.class);
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
//
//        System.out.println("-----------------Update point------------------");
//
//        wayPointDAO.updateWayPoint(p1, point1New);
//
//        System.out.println("new id =" + wayPointDAO.readWayPoint(p1).getId());
//        System.out.println("new track id = " + wayPointDAO.readWayPoint(p1).getRouteId());
//        System.out.println("new x = " + wayPointDAO.readWayPoint(p1).getX());
//        System.out.println("new y = " + wayPointDAO.readWayPoint(p1).getY());
//        System.out.println("new height = " + wayPointDAO.readWayPoint(p1).getHeight());
//        System.out.println("new accuracy = " + wayPointDAO.readWayPoint(p1).getAccuracy());
//        System.out.println("new add time = " + wayPointDAO.readWayPoint(p1).getAddTime());
//
//        System.out.println("-----------------Delete point------------------");
//
//        wayPointDAO.deleteWayPoint(p1);
//        System.out.println("Point with id = " + p1 + " was deleted");
//
//        System.out.println("-----------------List points for track_id = " + point1.getRouteId() +"------------------");
//
//        List<WayPoint> list = wayPointDAO.getSortedWayPointsForRoute(point2.getRouteId());
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Point id = " + list.get(i).getId() + " Add datetime = " + list.get(i).getAddTime());
//        }
//    }
}
