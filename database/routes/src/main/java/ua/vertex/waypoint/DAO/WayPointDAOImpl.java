package ua.vertex.waypoint.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ua.vertex.waypoint.Entity.WayPoint;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vasyl on 18/05/2016.
 */
@Repository
public class WayPointDAOImpl implements WayPointDAO {

    private NamedParameterJdbcTemplate myRepo;

    @Autowired
    public WayPointDAOImpl(DataSource dataSource) {
        this.myRepo = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String CREATE =
            "INSERT INTO routes.waypoint (id, track_id, x, y, height, accuracy) VALUES(:id, :track_id,:x,:y,:height,:accuracy)";
    private static final String READ =
            "SELECT id, track_id, x, y, height, accuracy, get_time FROM routes.waypoint WHERE id = :id";
    private static final String UPDATE =
            "UPDATE routes.waypoint SET track_id = :track_id, x = :x, y = :y, height = :height, accuracy = :accuracy WHERE id = :id";
    private static final String DELETE =
            "DELETE FROM routes.waypoint WHERE id = :id";
    private static final String SELECT_ALL_WAYPOINT_TO_ROUTE =
            "SELECT id, track_id, x, y, height, accuracy, get_time FROM routes.waypoint WHERE track_id = :track_id ORDER BY get_time ASC;";


    @Override
    public void create(WayPoint wayPoint) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", wayPoint.getId())
                .addValue("track_id", wayPoint.getRouteId())
                .addValue("x", wayPoint.getX())
                .addValue("y", wayPoint.getY())
                .addValue("height", wayPoint.getHeight())
                .addValue("accuracy", wayPoint.getAccuracy());

        myRepo.update(CREATE, namedParameters);
    }

    @Override
    public WayPoint read(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        WayPoint wayPoint = myRepo.queryForObject(READ, namedParameters, new WayPointRowMapper());
        return wayPoint;
    }

    @Override
    public void update(long id, WayPoint wayPoint) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("track_id", wayPoint.getRouteId())
                .addValue("x", wayPoint.getX())
                .addValue("y", wayPoint.getY())
                .addValue("height", wayPoint.getHeight())
                .addValue("accuracy", wayPoint.getAccuracy())
                .addValue("id", id);
        myRepo.update(UPDATE, namedParameters);
    }

    @Override
    public void delete(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        myRepo.update(DELETE, namedParameters);
    }

    @Override
    public List<WayPoint> getSortedWayPointsForRoute(long routeId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("track_id", routeId);
        List<WayPoint> wayPoints = myRepo.query(SELECT_ALL_WAYPOINT_TO_ROUTE, namedParameters, new WayPointRowMapper());
        Collections.sort(wayPoints);
        return wayPoints;
    }

    class WayPointRowMapper implements RowMapper<WayPoint> {

        @Override
        public WayPoint mapRow(ResultSet rs, int rowNum) throws SQLException {
            WayPoint wayPoint = WayPoint.newBuilder()
                    .setId(rs.getLong("id"))
                    .setRouteId(rs.getLong("track_id"))
                    .setX(rs.getDouble("x"))
                    .setY(rs.getDouble("y"))
                    .setHeight(rs.getInt("height"))
                    .setAccuracy(rs.getInt("accuracy"))
                    .setAddTime(rs.getTimestamp("get_time"))
                    .build();
            return wayPoint;
        }
    }
}