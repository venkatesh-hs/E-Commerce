package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.Cart;
import com.revival.inventory.book.entities.CartItem;

import java.math.BigInteger;

public interface CartService {
    Cart addToCart(CartItem cartItem);

    Cart getUserCart(BigInteger userId);

    Cart removeFromCart(BigInteger userId, BigInteger bookId);
}
