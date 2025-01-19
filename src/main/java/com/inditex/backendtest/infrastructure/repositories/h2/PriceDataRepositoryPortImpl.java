package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;

import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class PriceDataRepositoryPortImpl implements PriceRepositoryPort {

    private final PriceDataRepository priceDataRepository;
    private final PriceMapper priceMapper;


    public PriceDataRepositoryPortImpl(PriceDataRepository priceDataRepository, PriceMapper priceMapper) {
        this.priceDataRepository = priceDataRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Price savePrice(Price price) {

        PriceEntity priceEntity = priceMapper.priceDomainToPriceEntity(price);
        PriceEntity savedPriceEntity = priceDataRepository.save(priceEntity);
        return priceMapper.priceEntityToPriceDomain(savedPriceEntity);
    }

    @Override
    public Optional<List<Price>> getPrices(int productId) {

        Optional<List<PriceEntity>> priceEntityList = priceDataRepository.findPricesByProductId(productId);

        return priceEntityList.map(entities -> entities.stream()
                .map(priceMapper::priceEntityToPriceDomain)
                .toList());
    }

    @Override
    public Optional<List<Price>> findPricesByDate(int productId, int brandId, Date date) {

        Optional<List<PriceEntity>> priceEntityList = priceDataRepository.findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(productId, brandId, date);

        return priceEntityList.map(entities -> entities.stream()
                .map(priceMapper::priceEntityToPriceDomain)
                .toList());
    }
}
