package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.User;
import com.revival.inventory.book.repository.UserRepository;
import com.revival.inventory.book.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
