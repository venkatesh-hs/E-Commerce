package com.revival.inventory.book.controller;

import com.revival.inventory.book.entities.Book;
import com.revival.inventory.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    private ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    private ResponseEntity<List<Book>> getBook() {
        return ResponseEntity
                .ok()
                .body(bookService.getBooks());
    }
}
