package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;

public class CreatePriceService implements CreatePrice {

    private final CreatePrice createPrice;

    public CreatePriceService(CreatePrice createPrice) {
        this.createPrice = createPrice;
    }

    @Override
    public Price createPrice(Price price) {
        return createPrice.createPrice(price);
    }
}
