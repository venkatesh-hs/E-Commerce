package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> getUsers();
}
