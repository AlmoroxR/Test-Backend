package com.inditex.backendtest.application.usecases;

import com.inditex.backendtest.domain.models.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.out.PriceRepository;

/**
 * Caso de uso para la creación de precios.
 * Implementa la interfaz {@link CreatePrice} para crear precios.
 */
public class CreatePriceImpl implements CreatePrice {

    private final PriceRepository priceRepository;

    /**
     * Constructor de la clase CreatePriceImpl.
     *
     * @param priceRepository Repositorio de precios para guardar precios.
     */
    public CreatePriceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Price createPrice(Price price) {
        return priceRepository.savePrice(price);
    }
}
