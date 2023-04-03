package com.revival.inventory.book.service;

import com.revival.inventory.book.entities.Book;

import java.util.List;

public interface BookService {

    void createBook(Book book);

    List<Book> getBooks();
}
