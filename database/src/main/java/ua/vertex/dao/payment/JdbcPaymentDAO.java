package ua.vertex.dao.payment;

import entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Vasyl on 27/05/2016.
 */
@Repository
public class JdbcPaymentDAO implements PaymentDAO {
    private NamedParameterJdbcTemplate myRepo;

    @Autowired
    public JdbcPaymentDAO(DataSource dataSource) {
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

    @Override
    public void create(Payment payment) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", payment.getId())
                .addValue("user_id", payment.getUserId())
                .addValue("amount", payment.getAmount());

        myRepo.update(CREATE, namedParameters);
    }

    @Override
    public Payment read(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        return myRepo.queryForObject(READ, namedParameters, new PaymentRowMapper());
    }

    @Override
    public void update(long id, Payment payment) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_id", payment.getUserId())
                .addValue("amount", payment.getAmount())
                .addValue("id", id);

        myRepo.update(UPDATE, namedParameters);
    }

    @Override
    public void delete(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        myRepo.update(DELETE, namedParameters);
    }

    @Override
    public boolean isEnoughMoney(long id, int amount) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        int currentAmount = myRepo.queryForObject(READ, namedParameters, new PaymentRowMapper()).getAmount();
        return currentAmount >= amount;
    }

    private class PaymentRowMapper implements RowMapper<Payment> {

        @Override
        public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
            Payment payment = new Payment();
            payment.setId(rs.getLong("id"));
            payment.setUserId(rs.getLong("user_id"));
            payment.setAmount(rs.getInt("amount"));
            return payment;
        }
    }
}
