package com.bandeira.biblioteca_online.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "loans")
@Table(name = "loans")
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate withDraw;


    private LocalDate devolution;


    private Book book;


    private String numberLoan;


    private BigDecimal fine;


    private BigDecimal total;


    private String emailClient;


    private StatusLoan status;


    private String librarianResponsible;


    public Loan(LocalDate withDraw, LocalDate devolution, Book book, String numberLoan
            , BigDecimal total, String emailClient, StatusLoan status) {
        this.withDraw = withDraw;
        this.devolution = devolution;
        this.book = book;
        this.numberLoan = numberLoan;
        this.total = total;
        this.emailClient = emailClient;
        this.status = status;
    }
}
