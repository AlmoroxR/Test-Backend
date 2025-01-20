package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del caso de uso para encontrar el precio final de un producto.
 */
public class FindFinalPriceImpl implements FindFinalPrice {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase FindFinalPriceImpl.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     */
    public FindFinalPriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
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
        return priceRepositoryPort.findPricesByDate(productId, brandId, date)
                .map(this::findHighestPriorityPrice);
    }

    /**
     * Encuentra el precio con mayor prioridad de una lista de precios.
     *
     * @param prices Lista de precios.
     * @return Objeto Price con el precio de mayor prioridad.
     */
    private Price findHighestPriorityPrice(List<Price> prices) {
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow();
    }
}
