package ua.vertex.route.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ua.vertex.route.Entity.Route;
import ua.vertex.waypoint.DAO.WayPointDAO;
import ua.vertex.waypoint.DAO.WayPointDAOImpl;

import javax.sql.DataSource;

/**
 * Created by Дмитрий on 17.05.2016.
 */
@Service
public class RouteDAOImpl implements RouteDAO {


    JdbcTemplate jdbcTemplate;

    public RouteDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    WayPointDAO wayPointDAO;

    private static final String INSERTSQL = "INSERT INTO route VALUES(?,?)";
    private static final String SELECTSQL = "SELECT id,name FROM route WHERE id = ?";
    private static final String UPDATESQL = "UPDATE route SET name = ? WHERE id = ?";
    private static final String DELETESQL = "DELETE FROM route WHERE id = ?";

    @Override
    public void create(Route route) {
        jdbcTemplate.update(INSERTSQL,route.getId(),route.getName());
    }

    @Override
    public Route read(int id) {
        Route route = jdbcTemplate.queryForObject(SELECTSQL,new Object[]{id},new RouteMapper());
        route.setWayPoints(wayPointDAO.getSortedWayPointsForRoute(id));
        return route;
    }

    @Override
    public void update(Route route, int id) {
        jdbcTemplate.update(UPDATESQL,route.getName(),id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETESQL,id);
    }
}
