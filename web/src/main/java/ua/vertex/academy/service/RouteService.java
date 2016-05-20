package ua.vertex.academy.service;

import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.Entity.WayPoint;

/**
 * Created by RASTA on 19.05.2016.
 */
public interface RouteService {
    long create(Route route);

    Route get(long id);

    void update(long id, Route route);

    void delete(long id);

    void addWaypoint(WayPoint wayPoint);

    void deleteWayPoint(int id);
}
