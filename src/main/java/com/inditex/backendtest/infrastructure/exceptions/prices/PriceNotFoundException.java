package com.inditex.backendtest.infrastructure.exceptions.prices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException() {
        super("Price not found");
    }
}