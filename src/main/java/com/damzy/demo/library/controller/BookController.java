package com.damzy.demo.library.controller;

import com.damzy.demo.library.model.request.BookRequest;
import com.damzy.demo.library.model.response.BookListResponse;
import com.damzy.demo.library.model.response.BookResponse;
import com.damzy.demo.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/books", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookListResponse> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public BookResponse addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public BookResponse editBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        return bookService.editBook(id, bookRequest);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}
