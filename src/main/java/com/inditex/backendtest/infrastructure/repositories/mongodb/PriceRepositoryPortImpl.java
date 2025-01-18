package com.inditex.backendtest.infrastructure.repositories.mongodb;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import com.inditex.backendtest.infrastructure.entities.mongodb.PriceEntity;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;

import java.util.Date;
import java.util.Optional;

public class PriceRepositoryPortImpl implements PriceRepositoryPort {

    private final PriceRepository priceRepository;

    public PriceRepositoryPortImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price savePrice(Price price) {

        PriceEntity priceEntity = PriceMapper.mapToPriceEntity(price);
        PriceEntity savedPriceEntity = priceRepository.save(priceEntity);
        return PriceMapper.mapToDomainPrice(savedPriceEntity);
    }

    @Override
    public Optional<Price> getPrices(int productId) {

        Optional<PriceEntity> priceEntity = priceRepository.findByProductId(productId);


        return Optional.empty();
    }
}
