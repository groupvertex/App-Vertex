package all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Vasyl on 02/07/2016.
 */
public class JdbcTemplateConfigManagerDAO implements PropertiesDAO {
    private NamedParameterJdbcTemplate myRepo;

    @Autowired
    public void JdbcConfigManagerDAO(DataSource dataSource) {
        this.myRepo = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String CREATE =
            "INSERT INTO users.payment (id, user_id, amount) VALUES(:id, :user_id, :amount)";
    private static final String READ =
            "SELECT id, user_id, amount FROM users.payment WHERE id = :id";
    private static final String UPDATE =
            "UPDATE users.payment SET user_id = :user_id, amount = :amount WHERE id = :id";
    private static final String DELETE =
            "DELETE FROM users.payment WHERE id = :id";

    public void get(String name) {

    }
}
