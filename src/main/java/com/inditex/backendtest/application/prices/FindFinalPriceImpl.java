package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FindFinalPriceImpl implements FindFinalPrice {

    private final PriceRepositoryPort priceRepositoryPort;

    public FindFinalPriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<Price> findFinalPrice(int productId, int brandId, Date date) {
        return priceRepositoryPort.findPricesByDate(productId, brandId, date)
                .map(this::findHighestPriorityPrice);
    }

    private Price findHighestPriorityPrice(List<Price> prices) {
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow();
    }
}
