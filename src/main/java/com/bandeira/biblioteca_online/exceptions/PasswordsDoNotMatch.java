package com.bandeira.biblioteca_online.exceptions;

public class PasswordsDoNotMatch extends RuntimeException{


    public PasswordsDoNotMatch(){
        super("Passwords do not match");
    }


    public PasswordsDoNotMatch(String message){
        super(message);
    }

}
