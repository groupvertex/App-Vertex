package ua.vertex.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vertex.route.DAO.RouteDAO;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.DAO.WayPointDAO;
import ua.vertex.waypoint.Entity.WayPoint;

import java.util.List;

/**
 * Created by RASTA on 19.05.2016.
 */
@Repository
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDAO routeDAO;

    @Autowired
    WayPointDAO wayPointDAO;

    @Override
    public long create(Route route) {
        routeDAO.create(route);
        for (WayPoint wayPoint : route.getWayPoints()) {
            wayPointDAO.create(wayPoint);
        }
        return route.getId();
    }

    @Override
    public Route read(long id) {
        Route route = routeDAO.read(id);
        return route;
    }

    @Override
    public void update(long id, Route route) {
        routeDAO.update(route, id);
        List<WayPoint> fromStorage = routeDAO.read(route.getId()).getWayPoints(); // TODO: 21.05.2016 refactor according to the Set<WayPoint>
        route.getWayPoints().stream().filter(wayPoint -> !fromStorage.contains(wayPoint)).forEach(wayPoint -> {
            wayPointDAO.create(wayPoint);
        });

    }

    @Override
    public void delete(long id) {
        routeDAO.delete(id);
    }


}
