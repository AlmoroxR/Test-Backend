package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.models.Price;

public interface ExternalService {

    Price getPrice(int brandId, int productId, String date);
}
