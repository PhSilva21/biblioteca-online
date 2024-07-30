package com.bandeira.biblioteca_online.repositories;

import com.bandeira.biblioteca_online.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {


    Loan findByNumberLoan(String numberLoan);
}
