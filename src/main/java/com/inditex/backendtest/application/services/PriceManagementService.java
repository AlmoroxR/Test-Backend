package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.GetPrice;

import java.util.Date;
import java.util.Optional;

/**
 * Servicio para la gestión de precios.
 * Implementa las interfaces {@link CreatePrice} y {@link GetPrice} para la creación y consulta de precios.
 */
public class PriceManagementService implements CreatePrice, GetPrice {

    private final CreatePrice createPrice;
    private final GetPrice getPrice;

    /**
     * Constructor de la clase PriceService.
     *
     * @param createPrice Implementación de la interfaz {@link CreatePrice} para la creación de precios.
     * @param getPrice    Implementación de la interfaz {@link GetPrice} para la consulta de precios.
     */
    public PriceManagementService(CreatePrice createPrice, GetPrice getPrice) {
        this.createPrice = createPrice;
        this.getPrice = getPrice;
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
    public Optional<Price> getPrice(int brandId, int productId, Date date) {
        return getPrice.getPrice(brandId, productId, date);
    }
}
