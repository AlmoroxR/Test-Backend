package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.Date;
import java.util.Optional;

public interface FindFinalPrice {

    Optional<Price> findFinalPrice(int productId, int brandId, Date date);
}
