package ua.vertex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vertex.dao.route.RouteDAO;
import entity.Route;
import ua.vertex.dao.waypoint.WayPointDAO;
import entity.WayPoint;
import ua.vertex.exception.RouteNotFoundException;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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
        route.getWayPoints().parallelStream().map(p -> getRightPoint(p, id)).forEach(wayPointDAO::create);
        return route.getId();
    }

    private WayPoint getRightPoint(WayPoint p, long routeId) {
        return WayPoint.newBuilder()
                .setId(ThreadLocalRandom.current().nextLong())
                .setRouteId(routeId)
                .setX(p.getX())
                .setY(p.getY())
                .setHeight(p.getHeight())
                .setAccuracy(p.getAccuracy())
                .setAddTime(p.getAddTime()).build();
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
        List<WayPoint> newPoints = route.getWayPoints().parallelStream().map(p -> getRightPoint(p, id)).distinct().collect(Collectors.toList());
        newPoints.removeAll(wayPointDAO.getSortedWayPointsForRoute(id));
        newPoints.forEach(wayPointDAO::create);
    }

    @Override
    public void delete(long id) {
        routeDAO.delete(id);
    }

}
