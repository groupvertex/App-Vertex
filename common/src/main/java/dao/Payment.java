package dao;

/**
 * Created by Nick on 6/27/2016.
 */
public class Payment implements PaymentDao{
    private static long serialVersionUID = 123456789L;

    private long id;
    private long userId;
    private int amount;

    public Payment(long id, long userId, int amount) {
        this.id = id;
        this.userId = userId;
//        Amount money in cents
        this.amount = amount;
    }

    public Payment() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
