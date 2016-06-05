package ua.vertex.service;

import entity.User;

public interface UserService {
    long create(User user);

    User read(long id);

    void update(long id, User user);

    void delete(long id);
}
