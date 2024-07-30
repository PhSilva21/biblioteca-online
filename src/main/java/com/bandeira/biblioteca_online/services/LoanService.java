package com.bandeira.biblioteca_online.services;

import com.bandeira.biblioteca_online.dtos.RentBookDTO;
import com.bandeira.biblioteca_online.exceptions.BookNotFoundException;
import com.bandeira.biblioteca_online.exceptions.LoanNotFoundException;
import com.bandeira.biblioteca_online.exceptions.UserNotFoundException;
import com.bandeira.biblioteca_online.model.Loan;
import com.bandeira.biblioteca_online.model.StatusLoan;
import com.bandeira.biblioteca_online.repositories.BookRepository;
import com.bandeira.biblioteca_online.repositories.LoanRepository;
import com.bandeira.biblioteca_online.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class LoanService {


    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;


    public String rentBook(RentBookDTO rentBookDTO) {
        var user = userRepository.findByEmail(rentBookDTO.userEmail());

        if (user == null) {
            throw new UserNotFoundException();
        }

        var book = bookRepository.findByIsbn(rentBookDTO.isbn());

        if (book == null) {
            throw new BookNotFoundException();
        }

        Loan loan = new Loan(
                rentBookDTO.withDraw(),
                rentBookDTO.devolution(),
                book,
                UUID.randomUUID().toString(),
                book.getPriceDay(),
                user.getUsername(),
                StatusLoan.RESERVED
        );

        loanRepository.save(loan);

        return "Your book awaits you in our unit";
    }


    public Loan findByNumberLoan(String number) {
        var loan = loanRepository.findByNumberLoan(number);
        if (loan == null) {
            throw new LoanNotFoundException();
        }
        return loan;
    }


    public String deleteById(Long id ) {
        var loan = loanRepository.findById(id).orElseThrow(LoanNotFoundException::new);

        if (loan.getStatus().equals(StatusLoan.RESERVED)) {
            return "It is not possible to cancel, the loan has already been invoiced.";
        }

        loanRepository.deleteById(id);

        return "Loan application canceled";
    }

}
