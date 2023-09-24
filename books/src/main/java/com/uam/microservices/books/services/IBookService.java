package com.uam.microservices.books.services;

import com.uam.microservices.books.dtos.BookDTO;
import com.uam.microservices.books.dtos.RequestEditBookDTO;
import com.uam.microservices.books.entities.BookEntity;

import java.util.List;

public interface IBookService {
    BookEntity getById(Long bookId);

    List<BookDTO> getCatalogBooks();

    Boolean editBasicInformation(RequestEditBookDTO requestEditBook);

    Boolean addNumberCopies(Long bookId, Long numberCopies);

    Boolean loanBookById(Long bookId);

    Boolean handoverBookById(Long bookId);

    Boolean deleteBook(Long bookId);
}
