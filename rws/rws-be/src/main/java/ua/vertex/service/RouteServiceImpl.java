package ua.vertex.service;

import entity.Route;
import entity.WayPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vertex.dao.route.RouteDAO;
import ua.vertex.dao.waypoint.WayPointDAO;
import ua.vertex.exception.RouteNotFoundException;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteDAO routeDAO;

    @Autowired
    WayPointDAO wayPointDAO;


    public long create(Route route) {
        long id = ThreadLocalRandom.current().nextLong();
        route.setId(id);
        routeDAO.create(route);
        route.getWayPoints().stream().forEach(point -> {
            WayPoint newPoint = WayPoint.newBuilder()
                    .setRouteId(id)
                    .setId(ThreadLocalRandom.current().nextLong())
                    .setX(point.getX())
                    .setY(point.getY())
                    .setHeight(point.getHeight())
                    .setAccuracy(point.getAccuracy())
                    .setAddTime(point.getAddTime())
                    .build();
            wayPointDAO.create(newPoint);
        });
        return id;
    }

    public Route read(long id) {
        try {
            return routeDAO.read(id);
        } catch (Exception e) {
            throw new RouteNotFoundException("route with id:" + id + " not found");
        }
    }

    public void update(Route route, long id) {
        routeDAO.update(route, id);
    }

    public void delete(long id) {
        routeDAO.delete(id);
    }
}