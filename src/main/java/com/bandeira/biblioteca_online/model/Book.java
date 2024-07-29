package com.bandeira.biblioteca_online.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "books")
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;


    private String author;


    private BigDecimal priceDay;


    private String isbn;


    private AvailabilityBook availability;


    public Book(String title, String author, BigDecimal priceDay, String isbn
            , AvailabilityBook availability) {
        this.title = title;
        this.author = author;
        this.priceDay = priceDay;
        this.isbn = isbn;
        this.availability = availability;
    }
}
