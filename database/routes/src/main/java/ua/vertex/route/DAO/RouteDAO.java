package ua.vertex.route.DAO;

import ua.vertex.route.Entity.Route;

/**
 * Created by Дмитрий on 17.05.2016.
 */
public interface RouteDAO {

    void create(Route route);
    Route read(int id);
    void update(Route route, int id);
    void delete(int id);

}
