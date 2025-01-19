package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GetPricesService implements GetPrices {

    private final GetPrices getPrices;

    public GetPricesService(GetPrices getPrices) {
        this.getPrices = getPrices;
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }
}
