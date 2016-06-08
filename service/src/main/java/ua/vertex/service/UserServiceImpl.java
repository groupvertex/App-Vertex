package ua.vertex.service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vertex.dao.user.UserDAO;
import ua.vertex.exception.UserNotFoundException;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public long create(User user) {
        long id = ThreadLocalRandom.current().nextLong();
        user.setId(id);
        userDAO.create(user);
        return id;
    }

    public User read(long id) {
        try {
            return userDAO.read(id);
        } catch (Exception e) {
            throw new UserNotFoundException("user with id:" + id + " not found!");
        }
    }

    public void update(long id, User user) {
        userDAO.update(user, id);
    }

    public void delete(long id) {
        userDAO.delete(id);
    }

}
