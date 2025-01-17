package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.models.Price;

public interface CreatePrice {

    Price createPrice(Price price);
}
