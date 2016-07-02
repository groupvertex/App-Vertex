package dao;

/**
 * Created by Nick on 6/27/2016.
 */
public interface PaymentDao {
    public long getId();
    public void setId(long id);

    public long getUserId();
    public void setUserId(long userId);

    public int getAmount();
    public void setAmount(int amount);
}
