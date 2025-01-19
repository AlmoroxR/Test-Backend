package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

public class CreatePriceImpl implements CreatePrice {

    private final PriceRepositoryPort priceRepositoryPort;

    public CreatePriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price createPrice(Price price) {
        return priceRepositoryPort.savePrice(price);
    }
}
