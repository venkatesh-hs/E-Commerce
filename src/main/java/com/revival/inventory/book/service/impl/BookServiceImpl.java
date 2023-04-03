package com.revival.inventory.book.service.impl;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.repository.BookRepository;
import com.revival.inventory.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    
    public final BookRepository bookRepository;
    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
