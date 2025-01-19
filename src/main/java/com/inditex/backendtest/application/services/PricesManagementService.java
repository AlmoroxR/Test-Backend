package com.inditex.backendtest.application.services;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindPrices;
import com.inditex.backendtest.domain.ports.in.GetPrices;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de precios.
 * Implementa las interfaces {@link CreatePrice} y {@link GetPrices} para la creación y consulta de precios.
 */
public class PricesManagementService implements CreatePrice, GetPrices, FindPrices {

    private final CreatePrice createPrice;
    private final GetPrices getPrices;
    private final FindPrices findPrices;

    /**
     * Constructor de la clase PriceService.
     *
     * @param createPrice Implementación de la interfaz {@link CreatePrice} para la creación de precios.
     * @param getPrices    Implementación de la interfaz {@link GetPrices} para la consulta de precios.
     */
    public PricesManagementService(CreatePrice createPrice, GetPrices getPrices, FindPrices findPrices) {
        this.createPrice = createPrice;
        this.getPrices = getPrices;
        this.findPrices = findPrices;
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
    public Optional<List<Price>> getPrices(int productId) {
        return getPrices.getPrices(productId);
    }

    @Override
    public Optional<List<Price>> findPrices(int productId, int brandId, Date date) {
        return findPrices.findPrices(productId, brandId, date);
    }
}
