package com.revival.inventory.book.repository;

import com.revival.inventory.book.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, BigInteger> {
    @Query(value = "select book_id from _cart where user_id = ?1",
            nativeQuery = true)
    List<BigInteger> getUserBooks(BigInteger userId);
}
