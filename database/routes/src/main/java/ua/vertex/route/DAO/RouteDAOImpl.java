package ua.vertex.route.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.DAO.WayPointDAO;
import ua.vertex.waypoint.DAO.WayPointDAOImpl;
import ua.vertex.waypoint.Entity.WayPoint;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Дмитрий on 17.05.2016.
 */
@Repository
public class RouteDAOImpl implements RouteDAO {


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    WayPointDAO wayPointDAO;

    private static final String INSERTSQL = "INSERT INTO route (id, name) VALUES(:id,:name)";
    private static final String SELECTSQL = "SELECT id,name FROM route WHERE id = :id";
    private static final String UPDATESQL = "UPDATE route SET name = :name WHERE id = :id";
    private static final String DELETESQL = "DELETE FROM route WHERE id = :id";

    @Override
    public void create(Route route) {
        Map namedParameters = new HashMap<>();
        namedParameters.put("id",Long.valueOf(route.getId()));
        namedParameters.put("name",route.getName());
        jdbcTemplate.update(INSERTSQL,namedParameters);
    }

    @Override
    public Route read(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Long.valueOf(id));
        Route route = jdbcTemplate.queryForObject(SELECTSQL, namedParameters, new RouteMapper());

        List<WayPoint> list = wayPointDAO.getSortedWayPointsForRoute(id);
        route.setWayPoints(list);
        return route;
    }

    @Override
    public void update(Route route, long id) {
        Map namedParameters = new HashMap<>();
        namedParameters.put("id",id);
        namedParameters.put("name",route.getName());
        jdbcTemplate.update(UPDATESQL,namedParameters);

    }

    @Override
    public void delete(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Long.valueOf(id));
        jdbcTemplate.update(DELETESQL, namedParameters);
    }
}
