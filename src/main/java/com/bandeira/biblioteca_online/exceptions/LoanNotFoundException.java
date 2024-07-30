package com.bandeira.biblioteca_online.exceptions;

public class LoanNotFoundException extends RuntimeException{


    public LoanNotFoundException(){
        super("Loan not found");
    }


    public LoanNotFoundException(String message){
        super(message);
    }
}
