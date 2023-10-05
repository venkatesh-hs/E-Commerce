package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.AuthenticatedUser;
import com.revival.inventory.book.entities.User;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    Optional<User> getUser(BigInteger userId);

    AuthenticatedUser authenticateUser(User user) throws Exception;
}
