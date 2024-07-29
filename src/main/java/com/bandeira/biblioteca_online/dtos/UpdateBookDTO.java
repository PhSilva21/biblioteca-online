package com.bandeira.biblioteca_online.dtos;

import com.bandeira.biblioteca_online.model.AvailabilityBook;

import java.math.BigDecimal;

public record UpdateBookDTO(


        Long id,


        String title,


        String author,


        BigDecimal priceDay,


        AvailabilityBook availability
) {
}
