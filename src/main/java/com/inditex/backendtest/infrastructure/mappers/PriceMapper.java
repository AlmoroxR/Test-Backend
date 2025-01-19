package com.inditex.backendtest.infrastructure.mappers;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.entities.rest.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriceMapper {

    PriceMapper priceMapper = Mappers.getMapper(PriceMapper.class);

    PriceDto priceDomainToPriceDto(Price price);
    Price priceDtoToPriceDomain(PriceDto priceDto);
    PriceEntity priceDomainToPriceEntity(Price price);
    Price priceEntityToPriceDomain(PriceEntity priceEntity);
}
