package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz del puerto de entrada para la obtención de precios.
 * Define el metodo para obtener los precios de un producto.
 */
public interface GetPrices {

    /**
     * Obtiene los precios de un producto.
     *
     * @param productId Identificador del producto.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    Optional<List<Price>> getPrices(int productId);
}