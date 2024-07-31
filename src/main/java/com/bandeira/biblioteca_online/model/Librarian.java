package com.bandeira.biblioteca_online.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity(name = "librarians")
@Table(name = "librarians")
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String email;


    private String cpf;


    private String accountBank;



    private List<Object> changes = new ArrayList<>();


    public Librarian(String name, String email, String cpf, String accountBank) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.accountBank = accountBank;
    }
}
