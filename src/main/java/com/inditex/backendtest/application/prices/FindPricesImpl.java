package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.FindPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FindPricesImpl implements FindPrices {

    private final PriceRepositoryPort priceRepositoryPort;

    public FindPricesImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<Price> findPrices(int productId, int brandId, Date date) {
        return priceRepositoryPort.findPrices(productId, brandId, date)
                .flatMap(prices -> prices.stream()
                        .max(Comparator.comparingInt(Price::getPriority)));    }
}
