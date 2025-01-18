package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.Optional;

public interface GetPrices {

    Optional<Price> getPrices(int productId);
}
