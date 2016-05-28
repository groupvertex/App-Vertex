package user.Entity.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import user.Entity.User;

import javax.activation.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 19.05.2016.
 */
@Component
public class UserDAOImpl implements UserDAO {


    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource data) {
        jdbcTemplate = new NamedParameterJdbcTemplate((javax.sql.DataSource) data);
    }

    private static final String INSERTSQL = "INSERT INTO user (id, first_name, last_name,email,password) VALUES(:id,:first_name,:last_name,:email, :password)";
    private static final String SELECTSQL = "SELECT * FROM user WHERE id = :id";
    private static final String UPDATESQL = "UPDATE user SET first_name = :first_name, last_name = :last_name, email = :email, password =  :password WHERE id = :id";
    private static final String DELETESQL = "DELETE FROM user WHERE id = :id";


    @Override
    public void create(User user) {
        Map paramMap = new HashMap<>();
        paramMap.put("id", Long.valueOf(user.getId()));
        paramMap.put("first_name", user.getFirstName());
        paramMap.put("last_name", user.getLastName());
        paramMap.put("email", user.getEmail());
        paramMap.put("password", user.getPassword());
        jdbcTemplate.update(INSERTSQL, paramMap);
    }

    @Override
    public User read(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Long.valueOf(id));
        User user = (User) jdbcTemplate.queryForObject(SELECTSQL, namedParameters, new UserMapper());
        return user;
    }

    @Override
    public void update(User user, long id) {
        Map paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("first_name", user.getFirstName());
        paramMap.put("last_name", user.getLastName());
        paramMap.put("email", user.getEmail());
        paramMap.put("password", user.getPassword());
        jdbcTemplate.update(UPDATESQL, paramMap);

    }

    @Override
    public void delete(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", Long.valueOf(id));
        jdbcTemplate.update(DELETESQL, namedParameters);
    }


    class UserMapper implements RowMapper {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }
}

