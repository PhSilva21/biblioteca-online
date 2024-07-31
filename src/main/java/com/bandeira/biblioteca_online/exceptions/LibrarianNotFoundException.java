package com.bandeira.biblioteca_online.exceptions;

public class LibrarianNotFoundException extends RuntimeException{


    public LibrarianNotFoundException(){
        super("Librarian not found");
    }

    public LibrarianNotFoundException(String message){
        super(message);
    }
}
