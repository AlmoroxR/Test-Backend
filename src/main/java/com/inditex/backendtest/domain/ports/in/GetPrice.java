package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.Date;
import java.util.Optional;

/**
 * Interfaz del puerto de entrada para obtener un precio.
 */
public interface GetPrice {

    /**
     * Obtiene el precio de un producto para una cadena en una fecha específica.
     *
     * @param brandId    El ID de la cadena.
     * @param productId  El ID del producto.
     * @param date       La fecha para la que se busca el precio.
     * @return          El precio del producto.
     */
    Optional<Price> getPrice(int brandId, int productId, Date date);
}
