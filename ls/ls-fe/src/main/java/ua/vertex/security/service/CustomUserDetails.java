package ua.vertex.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.vertex.dao.user.UserDAO;


@Component
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return userDAO.read(email);
        } catch (Exception e) {
            throw new UsernameNotFoundException(email + " not found!");
        }
    }
}
