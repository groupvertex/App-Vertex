package ua.vertex.service;

import entity.Route;

public interface RouteService {
    long create(Route route);

    Route read(long id);

    void update(Route route, long id);


    void delete(long id);
}
