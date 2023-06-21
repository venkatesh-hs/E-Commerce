package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.entities.Cart;
import com.revival.inventory.book.entities.CartItem;
import com.revival.inventory.book.repository.CartRepository;
import com.revival.inventory.book.service.BookService;
import com.revival.inventory.book.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookService bookService;

    @Override
    public CartItem addToCart(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Override
    public Cart getUserCart(BigInteger userId) {
        List<BigInteger> bookIds = cartRepository.getUserBooks(userId);
        return prepareUserCart(bookIds);
    }

    private Cart prepareUserCart(List<BigInteger> bookIds) {
        List<Book> books = bookIds.stream()
                .map(bookId -> bookService.getBook(bookId))
                .toList();

        int cartTotal = books.stream()
                .mapToInt(book -> book.getPrice().intValue())
                .sum();

        return new Cart(BigInteger.valueOf(cartTotal), books);
    }
}
