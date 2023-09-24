package com.uam.microservices.books.controllers;

import com.uam.microservices.books.dtos.BookDTO;
import com.uam.microservices.books.dtos.RequestEditBookDTO;
import com.uam.microservices.books.entities.BookEntity;
import com.uam.microservices.books.services.IBookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable("id") Long bookId) {

        return new ResponseEntity<>(bookService.getById(bookId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getCatalogBooks() {

        return new ResponseEntity<>(bookService.getCatalogBooks(), HttpStatus.OK);
    }

    @PutMapping("basic-information")
    public ResponseEntity<Boolean> editBook(@RequestBody RequestEditBookDTO requestEditBook) {

        return new ResponseEntity<>(bookService.editBasicInformation(requestEditBook), HttpStatus.OK);
    }

    @PutMapping("add-copies/book/{bookId}/number-copies/{numberCopies}")
    public ResponseEntity<Boolean> addNumberCopies(@PathVariable("bookId") Long bookId,
                                                   @PathVariable("numberCopies") Long numberCopies) {

        return new ResponseEntity<>(bookService.addNumberCopies(bookId, numberCopies), HttpStatus.OK);
    }

    @PutMapping("loanBook/{bookId}")
    public ResponseEntity<Boolean> loanBookById(@PathVariable("bookId") Long bookId){

        return new ResponseEntity<>(bookService.loanBookById(bookId), HttpStatus.OK);
    }

    @PutMapping("handover/{bookId}")
    public ResponseEntity<Boolean> handoverBookById(@PathVariable("bookId") Long bookId){

        return new ResponseEntity<>(bookService.handoverBookById(bookId), HttpStatus.OK);
    }

    @DeleteMapping("delete/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("bookId") Long bookId){

        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
    }

}
