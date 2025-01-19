package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import java.util.List;
import java.util.Optional;

/**
 * Implementa la interfaz {@link CreatePrice} para obtener un precios.
 */
public class GetPricesImpl implements GetPrices {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase GetPriceImpl.
     *
     * @param priceRepositoryPort Repositorio de precios para guardar precios.
     */
    public GetPricesImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<List<Price>> getPrices(int productId) {
        return priceRepositoryPort.getPrices(productId);
    }
}
