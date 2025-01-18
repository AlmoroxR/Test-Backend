package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.List;
import java.util.Optional;

public interface GetPrices {

    Optional<List<Price>> getPrices(int productId);
}
