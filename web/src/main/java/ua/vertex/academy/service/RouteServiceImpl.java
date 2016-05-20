package ua.vertex.academy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.vertex.academy.exception.RouteNotFoundException;
import ua.vertex.academy.exception.IncorrectDeletingException;
import ua.vertex.route.DAO.RouteDAO;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.DAO.WayPointDAO;
import ua.vertex.waypoint.Entity.WayPoint;

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
//        route.setId(ThreadLocalRandom.current().nextLong());
        routeDAO.create(route);
        for (WayPoint wayPoint : route.getWayPoints()) {
            wayPointDAO.createWayPoint(wayPoint);
        }
        return route.getId();
    }

    @Override
    public Route get(long id) {
        Route route = routeDAO.read(id);
        if (route == null) {
            throw new RouteNotFoundException("Route with id " + id + " not found!");
        }
        return route;
    }

    @Override
    public void update(long id, Route route) {
        routeDAO.update(route, id);
    }


    @Override
    public void delete(long id) {
        routeDAO.delete(id);
        if (!get(id).getName().equals("empty")) {
            throw new IncorrectDeletingException("Route with id " + id + " wasn't deleted!");
        }
    }

    @Override
    public void addWaypoint(WayPoint wayPoint) {
        wayPointDAO.createWayPoint(wayPoint);
    }

    @Override
    public void deleteWayPoint(int id) {
        wayPointDAO.deleteWayPoint(id);
        if (wayPointDAO.readWayPoint(id).getId() == id) {
            throw new IncorrectDeletingException("WayPoint with id " + id + " wasn't deleted!");
        }
    }
}
