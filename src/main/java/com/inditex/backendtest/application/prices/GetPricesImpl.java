package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del caso de uso para obtener los precios de un producto.
 */
public class GetPricesImpl implements GetPrices {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase GetPricesImpl.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     */
    public GetPricesImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * Obtiene todos los precios de un producto dado.
     *
     * @param productId Identificador del producto.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return priceRepositoryPort.getPrices(productId);
    }
}