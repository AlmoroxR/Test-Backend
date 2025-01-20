package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.Date;
import java.util.Optional;

/**
 * Interfaz del puerto de entrada para la búsqueda del precio final.
 * Define el metodo para encontrar el precio final de un producto.
 */
public interface FindFinalPrice {

    /**
     * Encuentra el precio final de un producto.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la marca.
     * @param date      Fecha de aplicación del precio.
     * @return Optional que contiene el objeto Price con la información del precio final, o vacío si no se encuentra.
     */
    Optional<Price> findFinalPrice(int productId, int brandId, Date date);
}