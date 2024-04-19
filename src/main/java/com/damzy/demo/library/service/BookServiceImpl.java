package com.damzy.demo.library.service;

import com.damzy.demo.library.entity.Book;
import com.damzy.demo.library.model.request.BookRequest;
import com.damzy.demo.library.model.response.BookListResponse;
import com.damzy.demo.library.model.response.BookResponse;
import com.damzy.demo.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookListResponse> getBooks() {
        List<Book> all = bookRepository.findAll();
        return all.stream()
                .map(book -> BookListResponse.builder()
                        .id(book.getId()).name(book.getName()).build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (Objects.isNull(book)) {
            return null;
        }

        return cvBookResponse(book);
    }

    @Override
    @Transactional
    public BookResponse addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setName(bookRequest.getName());
        bookRepository.save(book);

        return cvBookResponse(book);
    }

    @Override
    @Transactional
    public BookResponse editBook(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id).orElse(null);

        if (Objects.isNull(book)) {
            return null;
        }

        book.setName(bookRequest.getName());
        bookRepository.save(book);

        return cvBookResponse(book);
    }

    @Override
    @Transactional
    public String deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (Objects.isNull(book)) {
            return "BOOK NOT FOUND";
        }

        bookRepository.delete(book);

        return "BOOK DELETED";
    }

    private BookResponse cvBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }
}
