package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Date;
import java.util.Optional;

/**
 * Servicio para la gestión de precios.
 * Implementa las interfaces {@link CreatePrice} y {@link GetPrices} para la creación y consulta de precios.
 */
public class PricesManagementService implements CreatePrice, GetPrices {

    private final CreatePrice createPrice;
    private final GetPrices getPrices;

    /**
     * Constructor de la clase PriceService.
     *
     * @param createPrice Implementación de la interfaz {@link CreatePrice} para la creación de precios.
     * @param getPrices    Implementación de la interfaz {@link GetPrices} para la consulta de precios.
     */
    public PricesManagementService(CreatePrice createPrice, GetPrices getPrices) {
        this.createPrice = createPrice;
        this.getPrices = getPrices;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Price createPrice(Price price) {
        return createPrice.createPrice(price);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Price> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }
}
