package ua.vertex.dao.user;

import entity.User;

/**
 * Created by user on 04.06.2016.
 */
public interface UserDAO {
    void create(User user);

    User read(long id);

    User read(String email);

    void update(User user, long id);

    void delete(long id);
}
