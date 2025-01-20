package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.model.Price;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz del puerto de salida para el repositorio de precios.
 * Define los métodos para interactuar con la fuente de datos de precios.
 */
public interface PriceRepositoryPort {

    /**
     * Guarda un nuevo precio en el repositorio.
     *
     * @param price Objeto Price que contiene la información del precio a guardar.
     * @return Objeto Price con la información del precio guardado.
     */
    Price savePrice(Price price);

    /**
     * Obtiene todos los precios de un producto dado.
     *
     * @param productId Identificador del producto.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    Optional<List<Price>> getPrices(int productId);

    /**
     * Busca precios de un producto y marca en un rango de fechas dado.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la marca.
     * @param date      Fecha para la cual se buscan los precios.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    Optional<List<Price>> findPricesByDate(int productId, int brandId, Date date);
}