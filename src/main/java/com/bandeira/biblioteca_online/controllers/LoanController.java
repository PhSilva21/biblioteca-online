package com.bandeira.biblioteca_online.controllers;

import com.bandeira.biblioteca_online.dtos.RentBookDTO;
import com.bandeira.biblioteca_online.model.Loan;
import com.bandeira.biblioteca_online.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan")
public class LoanController {


    @Autowired
    private LoanService loanService;


    @PostMapping("/rentLoan")
    public ResponseEntity<String> rentLoan(@RequestBody RentBookDTO rentBook){
        var response = loanService.rentBook(rentBook);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("findByNumberRent")
    public ResponseEntity<Loan> findByNumberRent(@RequestParam @Param("numberLoan") String numberLoan){
        var response = loanService.findByNumberLoan(numberLoan);
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam @Param("id") Long id){
        var response = loanService.deleteById(id);
        return ResponseEntity.ok().body(response);
    }
}
