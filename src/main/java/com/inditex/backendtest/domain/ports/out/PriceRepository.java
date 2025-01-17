package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.models.Price;

import java.util.Optional;

public interface PriceRepository {

    Price savePrice(Price price);
    Optional<Price> getPrice(int brandId, int productId, String date);
}
