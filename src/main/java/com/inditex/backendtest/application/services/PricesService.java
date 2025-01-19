package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PricesService implements CreatePrice, FindFinalPrice, GetPrices {

    private final CreatePrice createPrice;
    private final FindFinalPrice findFinalPrice;
    private final GetPrices getPrices;

    public PricesService(CreatePrice createPrice, FindFinalPrice findFinalPrice, GetPrices getPrices) {
        this.createPrice = createPrice;
        this.findFinalPrice = findFinalPrice;
        this.getPrices = getPrices;
    }

    @Override
    public Price createPrice(Price price) {
        return createPrice.createPrice(price);
    }

    @Override
    public Optional<Price> findFinalPrice(int productId, int brandId, Date date) {
        return findFinalPrice.findFinalPrice(productId, brandId, date);
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }
}

