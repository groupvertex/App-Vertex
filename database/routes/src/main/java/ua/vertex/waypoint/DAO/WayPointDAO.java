package ua.vertex.waypoint.DAO;

import ua.vertex.waypoint.Entity.WayPoint;

import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
public interface WayPointDAO {
    long createWayPoint(WayPoint wayPoint);
    WayPoint readWayPoint(long id);
    void updateWayPoint(long id, WayPoint wayPoint);
    void deleteWayPoint(long id);
    List<WayPoint> getSortedWayPointsForRoute(long routeId);
}
