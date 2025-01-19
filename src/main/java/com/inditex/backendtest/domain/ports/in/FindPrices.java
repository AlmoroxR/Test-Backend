package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FindPrices {

    Optional<List<Price>> findPrices(int productId, int brandId, Date date);
}
