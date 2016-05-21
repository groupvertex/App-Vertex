package ua.vertex.academy.service;

import ua.vertex.route.Entity.Route;

/**
 * Created by RASTA on 19.05.2016.
 */
public interface RouteService {
    long create(Route route);

    Route read(long id);

    void update(long id, Route route);

    void delete(long id);
}
