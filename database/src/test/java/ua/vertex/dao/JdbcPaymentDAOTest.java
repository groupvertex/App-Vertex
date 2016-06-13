package ua.vertex.dao;

import entity.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.vertex.config.DBConfig;
import ua.vertex.dao.payment.PaymentDAO;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@ActiveProfiles("test")
public class JdbcPaymentDAOTest {

    @Autowired
    private PaymentDAO paymentDAO;

    @Test
    public void create() throws Exception {
        Payment actual = new Payment(2, 2, 1_000);
        paymentDAO.create(actual);
        Assert.assertEquals(2, actual.getId());
        Assert.assertEquals(2, actual.getUserId());
        Assert.assertEquals(1000, actual.getAmount());
    }

    @Test
    public void read() throws Exception {
        Payment payment = paymentDAO.read(1);
        Assert.assertEquals(1, payment.getId());
        Assert.assertEquals(1, payment.getUserId());
        Assert.assertEquals(1_000, payment.getAmount());
    }

    @Test
    public void update() throws Exception {
        Payment payment = new Payment(2, 5, 5_000);
        paymentDAO.update(2, payment);
        Assert.assertEquals(2, payment.getId());
        Assert.assertEquals(5, payment.getUserId());
        Assert.assertEquals(5_000, payment.getAmount());
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