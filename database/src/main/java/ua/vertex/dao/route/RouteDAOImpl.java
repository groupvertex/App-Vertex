package ua.vertex.dao.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import entity.Route;
import entity.WayPoint;
import ua.vertex.dao.waypoint.WayPointDAO;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class RouteDAOImpl implements RouteDAO {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private WayPointDAO wayPointDAO;

    @Autowired
    public RouteDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String INSERTSQL = "INSERT INTO routes.route (id, name) VALUES(:id,:name)";
    private static final String SELECTSQL = "SELECT id,name FROM routes.route WHERE id = :id";
    private static final String UPDATESQL = "UPDATE routes.route SET name = :name WHERE id = :id";
    private static final String DELETESQL = "DELETE FROM routes.route WHERE id = :id";

    @Override
    public void create(Route route) {
        Map namedParameters = new HashMap<>();
        namedParameters.put("id", route.getId());
        namedParameters.put("name", route.getName());
        jdbcTemplate.update(INSERTSQL, namedParameters);
    }

    @Override
    public Route read(long id) {

        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        Route route = jdbcTemplate.queryForObject(SELECTSQL, namedParameters, new RouteMapper());

        List<WayPoint> list = wayPointDAO.getSortedWayPointsForRoute(id);
        route.setWayPoints(list);
        return route;
    }

    @Override
    public void update(Route route, long id) {
        Map namedParameters = new HashMap<>();
        namedParameters.put("id", id);
        namedParameters.put("name", route.getName());
        jdbcTemplate.update(UPDATESQL, namedParameters);

    }

    @Override
    public void delete(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        jdbcTemplate.update(DELETESQL, namedParameters);
    }
}
