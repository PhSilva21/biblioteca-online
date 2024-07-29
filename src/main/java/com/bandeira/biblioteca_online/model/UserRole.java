package com.bandeira.biblioteca_online.model;


public enum UserRole {


    USER("user"),


    ADMIN("admin");


    private String role;


    UserRole(String role){
        this.role = role;
    }
}
