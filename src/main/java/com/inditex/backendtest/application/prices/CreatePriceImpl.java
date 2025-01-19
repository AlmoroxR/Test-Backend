package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

/**
 * Implementa la interfaz {@link CreatePrice} para crear precios.
 */
public class CreatePriceImpl implements CreatePrice {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase CreatePriceImpl.
     *
     * @param priceRepositoryPort Repositorio de precios para guardar precios.
     */
    public CreatePriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Price createPrice(Price price) {
        return priceRepositoryPort.savePrice(price);
    }
}
