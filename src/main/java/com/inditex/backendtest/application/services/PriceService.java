package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindPrices;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PriceService implements CreatePrice, FindPrices, GetPrices {

    private final CreatePrice createPrice;
    private final FindPrices findPrices;
    private final GetPrices getPrices;

    public PriceService(CreatePrice createPrice, FindPrices findPrices, GetPrices getPrices) {
        this.createPrice = createPrice;
        this.findPrices = findPrices;
        this.getPrices = getPrices;
    }

    @Override
    public Price createPrice(Price price) {
        return createPrice.createPrice(price);
    }

    @Override
    public Optional<Price> findPrices(int productId, int brandId, Date date) {
        return findPrices.findPrices(productId, brandId, date);
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }
}

