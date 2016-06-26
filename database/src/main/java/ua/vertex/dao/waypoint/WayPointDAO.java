package ua.vertex.dao.waypoint;

import entity.WayPoint;

import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
public interface WayPointDAO {
    void create(WayPoint wayPoint);
    WayPoint read(long id);
    void update(long id, WayPoint wayPoint);
    void delete(long id);
    List<WayPoint> getSortedWayPointsForRoute(long routeId);
}
