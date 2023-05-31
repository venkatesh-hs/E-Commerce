package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Cart;
import com.revival.inventory.book.repository.CartRepository;
import com.revival.inventory.book.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart AddToCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
