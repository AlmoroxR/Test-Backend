package com.inditex.backendtest.application.price;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.GetPrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.Date;
import java.util.Optional;

/**
 * Implementa la interfaz {@link CreatePrice} para obtener un precios.
 */
public class GetPriceImpl implements GetPrice {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase GetPriceImpl.
     *
     * @param priceRepositoryPort Repositorio de precios para guardar precios.
     */
    public GetPriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Price> getPrice(int brandId, int productId, Date date) {
        return priceRepositoryPort.getPrice(brandId, productId, date);
    }
}
