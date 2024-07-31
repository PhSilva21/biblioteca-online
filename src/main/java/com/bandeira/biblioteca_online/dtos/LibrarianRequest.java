package com.bandeira.biblioteca_online.dtos;

public record LibrarianRequest(


        String name,

        String email,

        String cpf,

        String accountBank
) {
}
