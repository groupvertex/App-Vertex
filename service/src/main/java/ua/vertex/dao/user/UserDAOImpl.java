package ua.vertex.dao.user;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 04.06.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(DataSource data) {
        jdbcTemplate = new NamedParameterJdbcTemplate(data);
    }

    private static final String INSERTSQL = "INSERT INTO users.register_user (id, first_name, last_name,email,password) VALUES(:id,:first_name,:last_name,:email, :password)";
    private static final String SELECTSQL = "SELECT * FROM users.register_user WHERE id = :id";
    private static final String UPDATESQL = "UPDATE users.register_user SET first_name = :first_name, last_name = :last_name, email = :email, password =  :password WHERE id = :id";
    private static final String DELETESQL = "DELETE FROM users.register_user WHERE id = :id";


    @Override
    public void create(User user) {
        Map paramMap = new HashMap<>();
        paramMap.put("id", user.getId());
        paramMap.put("first_name", user.getFirstName());
        paramMap.put("last_name", user.getLastName());
        paramMap.put("email", user.getEmail());
        paramMap.put("password", user.getPassword());
        jdbcTemplate.update(INSERTSQL, paramMap);
    }

    @Override
    public User read(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
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
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",id);
        jdbcTemplate.update(DELETESQL, namedParameters);
    }



}
