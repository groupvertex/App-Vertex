package ua.vertex.dao.route;

import entity.Route;

/**
 * Created by Дмитрий on 17.05.2016.
 */
public interface RouteDAO {

    void create(Route route);
    Route read(long id);
    void update(Route route, long id);
    void delete(long id);

}
