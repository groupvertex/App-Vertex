package ua.vertex.waypoint.DAO;

import ua.vertex.waypoint.Entity.WayPoint;

import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
public interface WayPointDAO {
    int createWayPoint(WayPoint wayPoint);
    WayPoint readWayPoint(int id);
    void updateWayPoint(int id, WayPoint wayPoint);
    void deleteWayPoint(int id);
    List<WayPoint> getSortedWayPointsForRoute(long routeId);
}
