package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;

import com.inditex.backendtest.infrastructure.exceptions.prices.DataAccessException;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del puerto de salida del repositorio de precios.
 * Utiliza el repositorio de datos de precios y el mapeador de precios para acceder y persistir los precios.
 */
@Component
public class PriceDataRepositoryPortImpl implements PriceRepositoryPort {

    private final PriceDataRepository priceDataRepository;
    private final PriceMapper priceMapper;

    /**
     * Constructor de la clase PriceDataRepositoryPortImpl.
     *
     * @param priceDataRepository Repositorio de datos de precios.
     * @param priceMapper         Mapeador de precios.
     */
    public PriceDataRepositoryPortImpl(PriceDataRepository priceDataRepository, PriceMapper priceMapper) {
        this.priceDataRepository = priceDataRepository;
        this.priceMapper = priceMapper;
    }

    /**
     * Guarda un nuevo precio en el repositorio.
     *
     * @param price Objeto Price con la información del precio a guardar.
     * @return Objeto Price con la información del precio guardado.
     */
    @Override
    public Price savePrice(Price price) {

        PriceEntity priceEntity = priceMapper.priceDomainToPriceEntity(price);
        PriceEntity savedPriceEntity = priceDataRepository.save(priceEntity);
        return priceMapper.priceEntityToPriceDomain(savedPriceEntity);
    }

    /**
     * Obtiene todos los precios de un producto dado.
     *
     * @param productId Identificador del producto.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    @Override
    public Optional<List<Price>> getPrices(int productId) {

        Optional<List<PriceEntity>> priceEntityList = priceDataRepository.findPricesByProductId(productId);

        return priceEntityList.map(entities -> entities.stream()
                .map(priceMapper::priceEntityToPriceDomain)
                .toList());
    }

    /**
     * Busca precios de un producto y marca en un rango de fechas dado.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la marca.
     * @param date      Fecha para la cual se buscan los precios.
     * @return Optional que contiene una lista de objetos Price con la información de los precios, o vacío si no se encuentran precios.
     */
    @Override
    public Optional<List<Price>> findPricesByDate(int productId, int brandId, Date date) {

        try {
            Optional<List<PriceEntity>> priceEntityList = priceDataRepository.findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(productId, brandId, date);

            return priceEntityList.map(entities -> entities.stream()
                    .map(priceMapper::priceEntityToPriceDomain)
                    .toList());

        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }
}