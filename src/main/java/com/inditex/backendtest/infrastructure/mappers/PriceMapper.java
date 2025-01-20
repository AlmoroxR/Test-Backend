package com.inditex.backendtest.infrastructure.mappers;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.entities.rest.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interfaz del mapeador para la entidad Price.
 * Define los métodos para convertir entre el dominio, DTO y la entidad de persistencia.
 */
@Mapper
public interface PriceMapper {

    PriceMapper priceMapper = Mappers.getMapper(PriceMapper.class);

    /**
     * Convierte un objeto Price del dominio a un DTO PriceDto.
     *
     * @param price Objeto Price del dominio.
     * @return Objeto PriceDto.
     */
    PriceDto priceDomainToPriceDto(Price price);

    /**
     * Convierte un DTO PriceDto a un objeto Price del dominio.
     *
     * @param priceDto Objeto PriceDto.
     * @return Objeto Price del dominio.
     */
    Price priceDtoToPriceDomain(PriceDto priceDto);

    /**
     * Convierte un objeto Price del dominio a una entidad PriceEntity.
     *
     * @param price Objeto Price del dominio.
     * @return Entidad PriceEntity.
     */
    PriceEntity priceDomainToPriceEntity(Price price);

    /**
     * Convierte una entidad PriceEntity a un objeto Price del dominio.
     *
     * @param priceEntity Entidad PriceEntity.
     * @return Objeto Price del dominio.
     */
    Price priceEntityToPriceDomain(PriceEntity priceEntity);
}
