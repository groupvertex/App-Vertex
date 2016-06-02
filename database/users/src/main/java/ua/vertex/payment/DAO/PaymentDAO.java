package ua.vertex.payment.DAO;

import ua.vertex.payment.Entity.Payment;

/**
 * Created by Vasyl on 27/05/2016.
 */
public interface PaymentDAO {
    void create(Payment payment);
    Payment read(long id);
    void update(long id, Payment payment);
    void delete(long id);
    boolean isEnoughMoney(long id, int amount);
}
