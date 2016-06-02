package ua.vertex.payment.Entity;

/**
 * Created by Vasyl on 27/05/2016.
 */
public class Payment {
    private static long serialVersionUID = 123456789L;

    private long id;
    private long userId;
    private int amount;

    public Payment(long id, long userId, int amount) {
        this.id = id;
        this.userId = userId;
//        Amount money in sents
        this.amount = amount;
    }

    public Payment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (id != payment.id) return false;
        if (userId != payment.userId) return false;
        return amount == payment.amount;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + amount;
        return result;
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
