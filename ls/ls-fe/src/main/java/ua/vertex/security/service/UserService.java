package ua.vertex.security.service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.vertex.dao.user.UserDAO;
import ua.vertex.security.JwtTokenUtil;
import ua.vertex.security.exception.UserExistException;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetails;

    public long signUp(User user) {
        long id = ThreadLocalRandom.current().nextLong();
        user.setId(id);
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        try {
            userDAO.create(user);
        } catch (Exception e) {
            throw new UserExistException("user with email: " + user.getUsername() + " is already exist!");
        }
        return id;
    }

    public boolean isValidRequest(String token, long userID) {
        String username = tokenUtil.getUsernameFromToken(token);
        User user = (User) userDetails.loadUserByUsername(username);
        if (!tokenUtil.validateToken(token, user) || (user.getId() != userID && !user.getAuthorities().contains("ROLE_ADMIN"))) {
            throw new AccessDeniedException("access denied");
        }
        return true;
    }

    public User read(String token, long id) {
        isValidRequest(token, id);
        return userDAO.read(id);
    }

    public void update(String token, long id, User user) {
        isValidRequest(token, id);
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.update(user, id);
    }

    public void delete(String token, long id) {
        isValidRequest(token, id);
        userDAO.delete(id);
    }

}
