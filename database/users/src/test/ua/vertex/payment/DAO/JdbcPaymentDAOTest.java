package ua.vertex.payment.DAO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.Conf;
import ua.vertex.payment.Entity.Payment;

import static org.junit.Assert.*;

/**
 * Created by Vasyl on 27/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Conf.class)
@ActiveProfiles("test")
public class JdbcPaymentDAOTest {

    @Autowired
    private PaymentDAO paymentDAO;

    @Test
    public void create() throws Exception {
        Payment actual = new Payment(2, 2, 1_000);
        paymentDAO.create(actual);
        assertEquals(2, actual.getId());
        assertEquals(2, actual.getUserId());
        assertEquals(1000, actual.getAmount());
    }

    @Test
    public void read() throws Exception {
        Payment payment = paymentDAO.read(1);
        assertEquals(1, payment.getId());
        assertEquals(1, payment.getUserId());
        assertEquals(1_000, payment.getAmount());
    }

    @Test
    public void update() throws Exception {
        Payment payment = new Payment(2, 5, 5_000);
        paymentDAO.update(2, payment);
        assertEquals(2, payment.getId());
        assertEquals(5, payment.getUserId());
        assertEquals(5_000, payment.getAmount());
    }

    @Test(expected = Exception.class)
    public void delete() throws Exception {
        paymentDAO.delete(2);
        paymentDAO.read(2);
    }

    @Test
    public void isEnoughMoney() throws Exception {
        int amount = 3000;
        assertEquals(false, paymentDAO.isEnoughMoney(1, amount));
    }

}