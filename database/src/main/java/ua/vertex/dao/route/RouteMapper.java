package ua.vertex.dao.route;

import org.springframework.jdbc.core.RowMapper;
import entity.Route;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Дмитрий on 17.05.2016.
 */
public class RouteMapper implements RowMapper<Route> {
    @Override
    public Route mapRow(ResultSet resultSet, int i) throws SQLException {
        Route route = new Route();
        route.setId(resultSet.getLong("id"));
        route.setName(resultSet.getString("name"));
        return route;
    }
}
