package com.inditex.backendtest.infrastructure.exceptions.prices;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException() {
        super("Price not found");
    }
}