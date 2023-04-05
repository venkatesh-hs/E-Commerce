package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.repository.BookRepository;
import com.revival.inventory.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepository bookRepository;
    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
