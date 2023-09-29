package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Role;
import com.revival.inventory.book.entities.User;
import com.revival.inventory.book.repository.UserRepository;
import com.revival.inventory.book.security.JwtService;
import com.revival.inventory.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    private final JwtService jwtService;

    @Override
    public void createUser(User requestUser) {
        User user = User
                .builder()
                .firstName(requestUser.getFirstName())
                .lastName(requestUser.getLastName())
                .email(requestUser.getEmail())
                .password(requestUser.getPassword())
                .token(jwtService.generateToken(requestUser))
                .role(Role.USER)
                .build();
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
