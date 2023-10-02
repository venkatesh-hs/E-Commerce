package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Role;
import com.revival.inventory.book.entities.User;
import com.revival.inventory.book.repository.UserRepository;
import com.revival.inventory.book.security.JwtService;
import com.revival.inventory.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void createUser(User requestUser) {
        User user = User
                .builder()
                .firstName(requestUser.getFirstName())
                .lastName(requestUser.getLastName())
                .email(requestUser.getEmail())
                .password(passwordEncoder.encode(requestUser.getPassword()))
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
    public String authenticateUser(User user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );
        return jwtService.generateToken(user);
    }
}
