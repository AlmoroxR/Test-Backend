package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetPricesImpl implements GetPrices {

    private final PriceRepositoryPort priceRepositoryPort;

    public GetPricesImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return priceRepositoryPort.getPrices(productId);
    }
}
