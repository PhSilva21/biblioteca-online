package com.bandeira.biblioteca_online.repositories;

import com.bandeira.biblioteca_online.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Long> {


    Librarian findByName(String name);
}
