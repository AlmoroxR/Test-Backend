package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

/**
 * Implementación del caso de uso para crear un nuevo precio.
 */
public class CreatePriceImpl implements CreatePrice {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor de la clase CreatePriceImpl.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     */
    public CreatePriceImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    /**
     * Crea un nuevo precio.
     *
     * @param price Objeto Price con la información del precio a crear.
     * @return Objeto Price con la información del precio creado.
     */
    @Override
    public Price createPrice(Price price) {
        return priceRepositoryPort.savePrice(price);
    }
}