package com.bandeira.biblioteca_online.repositories;

import com.bandeira.biblioteca_online.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


    Book findByName(String name);
}
