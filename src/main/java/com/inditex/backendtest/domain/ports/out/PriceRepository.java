package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.models.Price;

import java.util.Optional;

/**
 * Interfaz que define el repositorio de precios.
 * Proporciona métodos para guardar y obtener precios.
 */
public interface PriceRepository {


    /**
     * Guarda un precio en el repositorio.
     *
     * @param price Precio a guardar.
     * @return El precio guardado.
     */
    Price savePrice(Price price);

    /**
     * Obtiene un precio del repositorio según los criterios especificados.
     *
     * @param brandId  ID de la marca.
     * @param productId ID del producto.
     * @param date     Fecha de aplicación del precio.
     * @return Un Optional que contiene el precio si se encuentra, o vacío si no se encuentra.
     */
    Optional<Price> getPrice(int brandId, int productId, String date);
}
