package com.bandeira.biblioteca_online.exceptions;

public class IncorrectPasswordException extends RuntimeException{


    public IncorrectPasswordException(){
        super("Incorrect password");
    }


    public IncorrectPasswordException(String message){
        super(message);
    }
}
