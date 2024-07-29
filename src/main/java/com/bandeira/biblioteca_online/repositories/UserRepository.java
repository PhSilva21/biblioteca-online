package com.bandeira.biblioteca_online.repositories;

import com.bandeira.biblioteca_online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
