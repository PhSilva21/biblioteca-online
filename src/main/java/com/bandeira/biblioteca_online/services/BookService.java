package com.bandeira.biblioteca_online.services;

import com.bandeira.biblioteca_online.dtos.BookRequest;
import com.bandeira.biblioteca_online.dtos.UpdateBookDTO;
import com.bandeira.biblioteca_online.exceptions.BookNotFoundException;
import com.bandeira.biblioteca_online.model.AvailabilityBook;
import com.bandeira.biblioteca_online.model.Book;
import com.bandeira.biblioteca_online.repositories.BookRepository;
import com.bandeira.biblioteca_online.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    @Autowired
    private BookRepository bookRepository;


    public Book createBook(BookRequest bookRequest){

        var randomString = RandomString.generateRandomString(8);

        Book book = new Book(
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.priceDay(),
                randomString,
                AvailabilityBook.AVAILABLE);

        return bookRepository.save(book);
    }


    public String updateBook(UpdateBookDTO updateBookDTO) {

        var book = bookRepository.findById(updateBookDTO.id()).orElseThrow(BookNotFoundException::new);

        if (book == null) {
            throw new BookNotFoundException();
        }

        if (updateBookDTO.title() != null) {
            book.setTitle(updateBookDTO.title());
        }


        if (updateBookDTO.author() != null) {
            book.setAuthor(updateBookDTO.author());
        }


        if (updateBookDTO.priceDay() != null) {
            book.setPriceDay(updateBookDTO.priceDay());
        }


        if (updateBookDTO.availability() != null) {
            book.setAvailability(updateBookDTO.availability());
        }

        return "";
    }


    public void deleteById(Long id){
        var book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

        bookRepository.deleteById(id);
    }


    public Book findByName(String name){
        var book = bookRepository.findByName(name);

        if(book == null){
            throw new BookNotFoundException();
        }
        return book;
    }
}
