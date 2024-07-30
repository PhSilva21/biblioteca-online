package com.bandeira.biblioteca_online.controllers;

import com.bandeira.biblioteca_online.dtos.BookRequest;
import com.bandeira.biblioteca_online.dtos.UpdateBookDTO;
import com.bandeira.biblioteca_online.model.Book;
import com.bandeira.biblioteca_online.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("book")
public class BookController {


    @Autowired
    private BookService bookService;


    @PostMapping("/createBook")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {
        var response = bookService.createBook(bookRequest);
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody UpdateBookDTO updateBookDTO) {
        var response = bookService.updateBook(updateBookDTO);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/findByName")
    public ResponseEntity<Book> findByName(@RequestParam @Param("name") String name){
        var response = bookService.findByName(name);
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/deleteById")
    public ResponseEntity<Void> findById(@RequestParam @Param("id") String id){
        var response = bookService.findByName(id);
        return ResponseEntity.ok().build();
    }
}
