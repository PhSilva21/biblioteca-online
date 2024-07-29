package com.bandeira.biblioteca_online.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity(name = "loans")
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate withDraw;


    private LocalDate devolution;


    private Book book;


    private BigDecimal fine;


    private BigDecimal total;


    private String emailClient;


    private String librarianResponsible;
}
