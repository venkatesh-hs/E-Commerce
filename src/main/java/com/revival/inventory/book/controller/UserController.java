package com.revival.inventory.book.controller;

import com.revival.inventory.book.entities.User;
import com.revival.inventory.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUser(@PathVariable BigInteger id) {
        var user = userService.getUser(id);
        HttpStatus statusCode = HttpStatus.OK;
        if (user.isEmpty()) {
            statusCode = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity
                .status(statusCode)
                .body(user.orElse(null));
    }

    @GetMapping
    private ResponseEntity<List<User>> getUsers() {
        return ResponseEntity
                .ok()
                .body(userService.getUsers());
    }
}
