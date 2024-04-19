package com.damzy.demo.library.service;

import com.damzy.demo.library.model.request.BookRequest;
import com.damzy.demo.library.model.response.BookListResponse;
import com.damzy.demo.library.model.response.BookResponse;

import java.util.List;

public interface BookService {

    List<BookListResponse> getBooks();

    BookResponse getBook(Long id);

    BookResponse addBook(BookRequest bookRequest);

    BookResponse editBook(Long id, BookRequest bookRequest);

    String deleteBook(Long id);

}
