package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.model.Price;

import java.util.List;
import java.util.Optional;

public interface PriceRepositoryPort {

    Price savePrice(Price price);

    Optional<List<Price>> getPrices(int productId);
}
