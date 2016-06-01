package ua.vertex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.vertex.dao.route.RouteDAO;
import entity.Route;
import ua.vertex.dao.waypoint.WayPointDAO;
import entity.WayPoint;
import ua.vertex.exception.RouteNotFoundException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDAO routeDAO;

    @Autowired
    WayPointDAO wayPointDAO;

    @Override
    public long create(Route route) {
        if (route == null) {
            return -1;
        }
        long id = ThreadLocalRandom.current().nextLong();
        route.setId(id);
        routeDAO.create(route);
        for (WayPoint wayPoint : route.getWayPoints()) {
            wayPointDAO.create(wayPoint);
        }
        return route.getId();
    }

    @Override
    public Route read(long id) {
        try {
            return routeDAO.read(id);
        } catch (Exception e) {
            throw new RouteNotFoundException("Route with id:" + id + " not found!");
        }
    }

    @Override
    public void update(long id, Route route) {
        routeDAO.update(route, id);
        List<WayPoint> oldPoints = routeDAO.read(id).getWayPoints();
        List<WayPoint> newPoints = route.getWayPoints();
        newPoints.removeAll(oldPoints);
        try {
            for (WayPoint wp : newPoints) {
                wayPointDAO.create(wp);

            }
        } catch (Exception ignored) {

        }
    }

    @Override
    public void delete(long id) {
        routeDAO.delete(id);
    }

}
