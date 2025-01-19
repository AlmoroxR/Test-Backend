package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.FindPrices;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FindPricesService implements FindPrices {

    private final FindPrices findPrices;

    public FindPricesService(FindPrices findPrices) {
        this.findPrices = findPrices;
    }

    @Override
    public Optional<List<Price>> findPrices(int productId, int brandId, Date date) {
        return findPrices.findPrices(productId, brandId, date)
                .map(this::filterByPriority);
    }

    private List<Price> filterByPriority(List<Price> prices) {
        return prices.stream()
                .sorted(Comparator.comparingInt(Price::getPriority).reversed())
                .toList();
    }
}
