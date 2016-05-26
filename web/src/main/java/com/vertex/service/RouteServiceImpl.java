package com.vertex.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vertex.route.DAO.RouteDAO;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.DAO.WayPointDAO;
import ua.vertex.waypoint.Entity.WayPoint;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by RASTA on 19.05.2016.
 */
@Service
public class RouteServiceImpl implements RouteService {
    private static final Logger logger = Logger.getLogger(RouteServiceImpl.class);
    private final Route emptyRoute = new Route(-1, "empty");
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
        try {
            routeDAO.create(route);
            for (WayPoint wayPoint : route.getWayPoints()) {
                wayPointDAO.create(wayPoint);
            }
            return route.getId();

        } catch (Exception ex) {
            logger.warn(ex.getMessage());
        }
        return -1;

    }

    @Override
    public Route read(long id) {
        try {
            return routeDAO.read(id);
        } catch (Throwable throwable) {
            return emptyRoute;
        }
    }

    @Override
    public void update(long id, Route route) {
        try {
            routeDAO.update(route, id);
            List<WayPoint> oldPoints = routeDAO.read(id).getWayPoints();
            List<WayPoint> newPoints = route.getWayPoints();
            newPoints.removeAll(oldPoints);
            for (WayPoint wp : newPoints) {
                wayPointDAO.create(wp);

            }
        } catch (Exception ex) {
            logger.warn(ex.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        try {
            routeDAO.delete(id);
        } catch (Exception ex) {
            logger.warn(ex.getMessage());
        }
    }

}
