package com.revival.inventory.book.entities;

import java.math.BigInteger;
import java.util.List;

public class Cart {

    BigInteger totalPrice;
    List<Book> books;

    public Cart(BigInteger totalPrice, List<Book> books) {
        this.totalPrice = totalPrice;
        this.books = books;
    }

    public BigInteger getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigInteger totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
