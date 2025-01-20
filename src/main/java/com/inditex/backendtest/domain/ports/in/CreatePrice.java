package com.inditex.backendtest.domain.ports.in;

import com.inditex.backendtest.domain.model.Price;

/**
 * Interfaz del puerto de entrada para la creación de precios.
 * Define el metodo para crear un nuevo precio.
 */
public interface CreatePrice {

    /**
     * Crea un nuevo precio.
     *
     * @param price Objeto Price que contiene la información del precio a crear.
     * @return Objeto Price con la información del precio creado.
     */
    Price createPrice(Price price);
}