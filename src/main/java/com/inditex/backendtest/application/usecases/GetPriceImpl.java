package com.inditex.backendtest.application.usecases;

import com.inditex.backendtest.domain.models.Price;
import com.inditex.backendtest.domain.ports.in.GetPrice;
import com.inditex.backendtest.domain.ports.out.PriceRepository;

import java.util.Optional;

public class GetPriceImpl implements GetPrice {

    private final PriceRepository priceRepository;

    public GetPriceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPrice(int brandId, int productId, String date) {
        return priceRepository.getPrice(brandId, productId, date);
    }
}
