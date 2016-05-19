package user.Entity.DAO;

import user.Entity.User;

/**
 * Created by user on 18.05.2016.
 */
public interface UserDAO {



        void create(User user);
        User read(int id);
        void update(User user, int id);
        void delete(int id);


}
