package com.inditex.backendtest.infrastructure.mappers;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.mongodb.PriceEntity;

/**
 * Clase para mapear la entidad de MongoDB con la capa dominio.
 */
public class PriceMapper {

    /**
     * Mapea un objeto de dominio `Price` a una entidad `PriceEntity`.
     *
     * @param price El objeto de dominio `Price` a mapear.
     * @return La entidad `PriceEntity` mapeada.
     */
    public static PriceEntity mapToPriceEntity(Price price) {

        return new PriceEntity(
                price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriceList(),
                price.getProductId(),
                price.getPriority(),
                price.getPrice(),
                price.getCurrency());
    }

    /**
     * Mapea un objeto de entidad `PriceEntity` a un objeto de dominio `Price`.
     *
     * @param priceEntity El objeto de dominio `PriceEntity` a mapear.
     * @return El objeto de dominio `Price` mapeado.
     */
    public static Price mapToDomainPrice(PriceEntity priceEntity) {

        return new Price(
                priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPriceList(),
                priceEntity.getProductId(),
                priceEntity.getPriority(),
                priceEntity.getPrice(),
                priceEntity.getCurrency());
    }
}
