package dao;

/**
 * Created by Nick on 6/27/2016.
 */
public interface UserDao {

    public void setId(long id);
    public long getId();

    public void setFirstName(String firstName);
    public String getFirstName();

    public void setLastName(String lastName);
    public String getLastName();

    public void setEmail(String email);
    public String getEmail();

    public void setPassword(String password);
    public String getPassword();
}
