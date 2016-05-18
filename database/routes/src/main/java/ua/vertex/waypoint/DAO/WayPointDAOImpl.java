package ua.vertex.waypoint.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.vertex.waypoint.Configuration.Conf;
import ua.vertex.waypoint.Entity.WayPoint;

import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
@Repository
public class WayPointDAOImpl implements WayPointDAO {

//    @Autowired
//    @Qualifier("myRepo")
//    private JdbcTemplate myRepo;

    ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
    private JdbcTemplate myRepo = (JdbcTemplate) context.getBean("myRepo");

    private static final String CREATE = "INSERT INTO routes.waypoint (track_id, x, y, height, accuracy) VALUES(?,?,?,?,?)";
    private static final String READ = "SELECT id, track_id, x, y, height, accuracy, get_time FROM routes.waypoint WHERE id = ?";
    private static final String UPDATE = "UPDATE routes.waypoint SET track_id = ?, x = ?, y = ?, height = ?, accuracy = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM routes.waypoint WHERE id = ?";
    private static final String SELECT_ALL_WAYPOINT_TO_ROUTE =
            "SELECT id, track_id, x, y, height, accuracy, get_time FROM routes.waypoint WHERE track_id = ? ORDER BY get_time ASC;";

    public WayPointDAOImpl() {
    }

    @Override
    public int createWayPoint(WayPoint wayPoint) {
        KeyHolder holder = new GeneratedKeyHolder();
        myRepo.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, wayPoint.getRouteId());
                ps.setDouble(2, wayPoint.getX());
                ps.setDouble(3, wayPoint.getY());
                ps.setInt(4, wayPoint.getHeight());
                ps.setInt(5, wayPoint.getAccuracy());
                return ps;
            }
        }, holder);

        int newWayPointId = (int)holder.getKeys().get("id");
//        Timestamp timestamp = (Timestamp)holder.getKeys().get("get_time");

        return newWayPointId;
    }

    @Override
    public WayPoint readWayPoint(int id) {
        RowMapper<WayPoint> mapper = new RowMapper<WayPoint>() {
            @Override
            public WayPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                int routeId = rs.getInt("track_id");
                double x = rs.getDouble("x");
                double y = rs.getDouble("y");
                int height = rs.getInt("height");
                int accuracy = rs.getInt("accuracy");
                Timestamp addTime = rs.getObject("get_time", Timestamp.class);
                WayPoint wayPoint = new WayPoint(routeId, x, y, height, accuracy);
                wayPoint.setId(id);
                wayPoint.setAddTime(addTime);
                return wayPoint;
            }
        };
        return myRepo.queryForObject(READ, mapper, id);
    }

    @Override
    public void updateWayPoint(int id, WayPoint wayPoint) {
        myRepo.update(UPDATE,
                wayPoint.getRouteId(),
                wayPoint.getX(),
                wayPoint.getY(),
                wayPoint.getHeight(),
                wayPoint.getAccuracy(),
                id);
    }

    @Override
    public void deleteWayPoint(int id) {
        myRepo.update(DELETE, id);
    }

    @Override
    public List<WayPoint> getSortedWayPointsForRoute(int routeId) {
        List<WayPoint> wayPoints = this.myRepo.query(SELECT_ALL_WAYPOINT_TO_ROUTE, new RowMapper<WayPoint>() {
            @Override
            public WayPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
                WayPoint wayPoint = new WayPoint();
                wayPoint.setId(Integer.parseInt(rs.getString("id")));
                wayPoint.setRouteId(Integer.parseInt(rs.getString("track_id")));
                wayPoint.setX(Double.parseDouble(rs.getString("x")));
                wayPoint.setY(Double.parseDouble(rs.getString("y")));
                wayPoint.setHeight(Integer.parseInt(rs.getString("height")));
                wayPoint.setHeight(Integer.parseInt(rs.getString("accuracy")));
                wayPoint.setAddTime(Timestamp.valueOf(rs.getString("get_time")));

                return wayPoint;
            }
        }, routeId);
        Collections.sort(wayPoints);
        return wayPoints;
    }
}
