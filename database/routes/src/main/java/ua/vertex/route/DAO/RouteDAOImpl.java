package ua.vertex.route.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.vertex.route.Entity.Route;

/**
 * Created by Дмитрий on 17.05.2016.
 */
@Service
public class RouteDAOImpl implements RouteDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String INSERTSQL = "INSERT INTO route VALUES(?,?)";
    private static final String SELECTSQL = "SELECT * FROM route WHERE id = ?";
    private static final String UPDATESQL = "UPDATE route SET name = ? WHERE id = ?";
    private static final String DELETESQL = "DELETE FROM route WHERE id = ?";

    @Override
    public void create(Route route) {
        jdbcTemplate.update(INSERTSQL,route.getId(),route.getName());
        //TODO for waypoint
    }

    @Override
    public Route read(int id) {
        Route route = jdbcTemplate.queryForObject(SELECTSQL,new Object[]{id},new RouteMapper());
        return route;
        //TODO for waypoint
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
