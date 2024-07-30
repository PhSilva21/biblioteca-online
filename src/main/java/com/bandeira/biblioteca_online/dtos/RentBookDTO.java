package com.bandeira.biblioteca_online.dtos;

import java.time.LocalDate;

public record RentBookDTO(


        String userEmail,

        String isbn,


        LocalDate withDraw,


        LocalDate devolution



) {
}
