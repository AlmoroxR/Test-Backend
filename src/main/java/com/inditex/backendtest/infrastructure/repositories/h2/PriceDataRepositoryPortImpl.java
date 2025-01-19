package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PriceDataRepositoryPortImpl implements PriceRepositoryPort {

    private final PriceDataRepository priceDataRepository;

    public PriceDataRepositoryPortImpl(PriceDataRepository priceDataRepository) {
        this.priceDataRepository = priceDataRepository;
    }

    @Override
    public Price savePrice(Price price) {

        PriceEntity priceEntity = PriceMapper.mapToPriceEntity(price);
        PriceEntity savedPriceEntity = priceDataRepository.save(priceEntity);
        return PriceMapper.mapToDomainPrice(savedPriceEntity);
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {

        Optional<List<PriceEntity>> priceEntityList = priceDataRepository.findByProductId(productId);

        return priceEntityList.map(entities -> entities.stream()
                .map(PriceMapper::mapToDomainPrice)
                .toList());
    }


}
