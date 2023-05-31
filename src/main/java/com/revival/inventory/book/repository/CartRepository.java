package com.revival.inventory.book.repository;

import com.revival.inventory.book.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CartRepository extends JpaRepository<Cart, BigInteger> {
}
