package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.User;
import com.revival.inventory.book.repository.UserRepository;
import com.revival.inventory.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(BigInteger userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User validateUser(User user) throws Exception {
        User userFromDB = userRepository.findByEmail(user.getEmail());
        if (userFromDB == null) {
            throw new Exception("User with email " + user.getEmail() + " is not found");
        }
        if (userFromDB.getPassword().equals(user.getPassword())) {
            return userFromDB;
        }
        throw new Exception("Incorrect Password!");
    }
}
