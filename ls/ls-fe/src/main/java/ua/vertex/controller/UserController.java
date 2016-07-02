package ua.vertex.controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import ua.vertex.security.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(HttpServletRequest request, @PathVariable long id) {
        String token = request.getHeader(tokenHeader);
        return userService.read(token, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest request, @PathVariable long id, @RequestBody User user) {
        String token = request.getHeader(tokenHeader);
        userService.update(token, id, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(HttpServletRequest request, @PathVariable long id) {
        String token = request.getHeader(tokenHeader);
        userService.delete(token, id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void exceptionHandler() {

    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void accessDeniedHandler() {

    }
}
