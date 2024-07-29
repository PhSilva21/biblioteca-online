package com.bandeira.biblioteca_online.dtos;

import com.bandeira.biblioteca_online.model.AvailabilityBook;

import java.math.BigDecimal;

public record BookRequest(

        String title,


        String author,


        BigDecimal priceDay,


        AvailabilityBook availability
) {
}
