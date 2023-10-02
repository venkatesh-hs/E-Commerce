package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();

    Optional<User> getUser(BigInteger userId);

    String authenticateUser(User user) throws Exception;
}
