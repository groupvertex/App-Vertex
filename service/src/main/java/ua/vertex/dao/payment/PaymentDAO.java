package ua.vertex.dao.payment;


import entity.Payment;

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
