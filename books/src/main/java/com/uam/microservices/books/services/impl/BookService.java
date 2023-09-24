package com.uam.microservices.books.services.impl;

import com.uam.microservices.books.dtos.BookDTO;
import com.uam.microservices.books.dtos.RequestEditBookDTO;
import com.uam.microservices.books.dtos.SectionDTO;
import com.uam.microservices.books.entities.BookEntity;
import com.uam.microservices.books.repositories.BookRepository;
import com.uam.microservices.books.services.IBookService;
import com.uam.microservices.books.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookEntity getById(Long bookId) {
        return getBookEntityById(bookId);
    }

    @Override
    public List<BookDTO> getCatalogBooks() {

        Set<BookEntity> books = bookRepository.findAllByAviableCopiesIsTrueAndActiveIsTrue();



        return null;
    }

    @Override
    public Boolean editBasicInformation(RequestEditBookDTO requestEditBook) {

        BookEntity bookEntity = getBookEntityById(requestEditBook.getId());

        bookEntity.setTitle(requestEditBook.getTitle());
        bookEntity.setAuthor(requestEditBook.getAuthor());
        bookEntity.setGenre(requestEditBook.getGenre());

        return saveBookToRepository(bookEntity);

    }

    @Override
    public Boolean addNumberCopies(Long bookId, Long numberCopies) {

        BookEntity bookEntity = getBookEntityById(bookId);

        bookEntity.setTotalCopies(bookEntity.getTotalCopies() + numberCopies);

        bookEntity.setNumberCopies(bookEntity.getNumberCopies() + numberCopies);


        return saveBookToRepository(bookEntity);
    }

    @Override
    public Boolean loanBookById(Long bookId) {

        BookEntity bookEntity = getBookEntityById(bookId);

        if (!bookEntity.getAviableCopies() && bookEntity.getActive()){
            throw new IllegalArgumentException(Constantes.MENSAJE_ERROR_NO_MORE_BOOKS);
        }


        if ((bookEntity.getNumberCopies() - 1L) == 0){

            bookEntity.setNumberCopies(bookEntity.getNumberCopies() - 1);
            bookEntity.setAviableCopies(Boolean.FALSE);

        }

        return saveBookToRepository(bookEntity);

    }

    @Override
    public Boolean handoverBookById(Long bookId) {

        BookEntity bookEntity = getBookEntityById(bookId);




        bookEntity.setAvailableCopies(bookEntity.getAvailableCopies() + 1);

        return saveBookToRepository(bookEntity);
    }

    @Override
    public Boolean deleteBook(Long bookId) {

        BookEntity bookEntity = getBookEntityById(bookId);

        bookEntity.setActive(Boolean.FALSE);

        return saveBookToRepository(bookEntity);
    }

    private Boolean saveBookToRepository(BookEntity bookEntity) {

        try {
            bookRepository.save(bookEntity);

            return Boolean.TRUE;
        } catch (Exception e){

            throw new IllegalArgumentException(String.format(Constantes.MENSAJE_ERROR_NOT_SAVE));
        }
    }


    private BookEntity getBookEntityById(Long bookId){

        if (bookId == null || bookId <= 0 ){

            throw new IllegalArgumentException(String.format(Constantes.MENSAJE_ERROR_REQUIRED, "bookId"));

        }

        return bookRepository.findById(bookId).orElseThrow(()
                -> new NoSuchElementException(String.format(Constantes.MENSAJE_ERROR_NOT_EXIST, "de libro")));
    }

    private BookDTO buildBookDTO(BookEntity bookEntity){

        SectionDTO section = getSectionBySectionId(bookEntity.getSectionId());

        return BookDTO.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .totalCopies(bookEntity.getTotalCopies())
                .availableCopies(bookEntity.getAvailableCopies())
                .genre(bookEntity.getGenre())
                .build();

    }

    private SectionDTO getSectionBySectionId(Long sectionId){

        return SectionDTO.builder()
                .codeSection("A1")
                .sectionGenre("Novela")
                .build();

    }


}
