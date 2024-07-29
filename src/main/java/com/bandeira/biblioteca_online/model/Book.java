package com.bandeira.biblioteca_online.model;

import jakarta.persistence.*;

import java.math.BigDecimal;


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
}
