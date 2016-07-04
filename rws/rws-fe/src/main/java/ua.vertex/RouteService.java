package ua.vertex;

import entity.Route;
import entity.WayPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.vertex.dao.route.RouteDAO;
import ua.vertex.dao.waypoint.WayPointDAO;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by user on 03.07.2016.
 */
@Component
public class RouteService {


    @Autowired
    RouteDAO routeDAO;

    @Autowired
    WayPointDAO wayPointDAO;



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

}