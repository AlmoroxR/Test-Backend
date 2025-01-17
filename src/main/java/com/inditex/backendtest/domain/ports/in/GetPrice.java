package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.models.Price;

public interface GetPrice {

    Price getPrice(int brandId, int productId, String date);
}
