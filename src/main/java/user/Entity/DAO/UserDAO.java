package user.Entity.DAO;

import user.Entity.User;

/**
 * Created by user on 18.05.2016.
 */
public interface UserDAO {



        void create(User user);
        User read(long id);
        void update(User user, long id);
        void delete(long id);


}
