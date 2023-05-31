package com.revival.inventory.book.controller;

import com.revival.inventory.book.entities.Cart;
import com.revival.inventory.book.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    private ResponseEntity<Cart> AddToCart(@RequestBody Cart cart) {
        return ResponseEntity
                .ok()
                .body(cartService.AddToCart(cart));
    }
}
