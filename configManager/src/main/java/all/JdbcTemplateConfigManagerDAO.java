package all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateConfigManagerDAO implements PropertiesDAO {
    private NamedParameterJdbcTemplate myRepo;
    Map<String, String> map = new HashMap<>();

    @Autowired
    JdbcTemplateConfigManagerDAO(DataSource dataSource) {
        this.myRepo = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String READ =
            "SELECT value FROM config.config WHERE key = :key";

    public String get(String name) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("key", name);
        return myRepo.queryForObject(READ, namedParameters, new ConfigManagerRowMapper());
    }

    private class ConfigManagerRowMapper implements RowMapper<String> {
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString("value");
        }
    }

    public Map<String, String> getMap() {
        return map;
    }
}