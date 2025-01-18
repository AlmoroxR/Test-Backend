package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.models.Price;

/**
 * Interfaz para crear precios.
 */
public interface CreatePrice {

    /**
     * Crea un nuevo precio.
     *
     * @param price El precio a crear.
     * @return El precio creado.
     */
    Price createPrice(Price price);
}
