package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Servicio que implementa los casos de uso relacionados con los precios.
 * Actúa como un punto de entrada para la lógica de negocio relacionada con los precios.
 */
public class PricesService implements CreatePrice, FindFinalPrice, GetPrices {

    private final CreatePrice createPrice;
    private final FindFinalPrice findFinalPrice;
    private final GetPrices getPrices;

    /**
     * Constructor de la clase PricesService.
     *
     * @param createPrice    Implementación del caso de uso para crear un precio.
     * @param findFinalPrice Implementación del caso de uso para encontrar el precio final.
     * @param getPrices      Implementación del caso de uso para obtener los precios.
     */
    public PricesService(CreatePrice createPrice, FindFinalPrice findFinalPrice, GetPrices getPrices) {
        this.createPrice = createPrice;
        this.findFinalPrice = findFinalPrice;
        this.getPrices = getPrices;
    }

    /**
     * Crea un nuevo precio.
     *
     * @param price Objeto Price con la información del precio a crear.
     * @return Objeto Price con la información del precio creado.
     */
    @Override
    public Price createPrice(Price price) {
        return createPrice.createPrice(price);
    }

    /**
     * Encuentra el precio final de un producto para una marca y fecha dadas.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la marca.
     * @param date      Fecha para la cual se busca el precio.
     * @return Optional que contiene el objeto Price con la información del precio final, o vacío si no se encuentra.
     */
    @Override
    public Optional<Price> findFinalPrice(int productId, int brandId, Date date) {
        return findFinalPrice.findFinalPrice(productId, brandId, date);
    }

    /**
     * Obtiene todos los precios de un producto dado.
     *
     * @param productId Identificador del producto.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }
}
