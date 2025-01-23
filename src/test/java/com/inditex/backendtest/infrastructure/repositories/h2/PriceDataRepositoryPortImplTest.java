package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceDataRepositoryPortImplTest {

    @Mock
    private PriceDataRepository priceDataRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceDataRepositoryPortImpl priceDataRepositoryPortImpl;

    private Price price;
    private PriceEntity priceEntity;

    @BeforeEach
    public void setUp() {
        price = new Price(1, new Date(), new Date(), 1, 35455, 0, 35.50, "EUR");
        priceEntity = new PriceEntity(1, new Date(), new Date(), 1, 35455, 0, 35.50, "EUR");
    }

    @Test
    public void testSavePrice() {
        when(priceMapper.priceDomainToPriceEntity(price)).thenReturn(priceEntity);
        when(priceDataRepository.save(priceEntity)).thenReturn(priceEntity);
        when(priceMapper.priceEntityToPriceDomain(priceEntity)).thenReturn(price);

        Price savedPrice = priceDataRepositoryPortImpl.savePrice(price);

        assertEquals(price, savedPrice);
    }

    @Test
    public void testGetPrices() {
        List<PriceEntity> priceEntities = List.of(priceEntity);
        when(priceDataRepository.findPricesByProductId(35455)).thenReturn(Optional.of(priceEntities));
        when(priceMapper.priceEntityToPriceDomain(priceEntity)).thenReturn(price);

        Optional<List<Price>> retrievedPrices = priceDataRepositoryPortImpl.getPrices(35455);

        assertEquals(Optional.of(List.of(price)), retrievedPrices);
    }

    @Test
    public void testGetPrices_noPricesFound() {
        when(priceDataRepository.findPricesByProductId(35455)).thenReturn(Optional.empty());

        Optional<List<Price>> retrievedPrices = priceDataRepositoryPortImpl.getPrices(35455);

        assertEquals(Optional.empty(), retrievedPrices);
    }

    @Test
    public void testFindPricesByDate() {
        List<PriceEntity> priceEntities = List.of(priceEntity);
        when(priceDataRepository.findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(35455, 1, new Date()))
                .thenReturn(Optional.of(priceEntities));
        when(priceMapper.priceEntityToPriceDomain(priceEntity)).thenReturn(price);

        Optional<List<Price>> retrievedPrices = priceDataRepositoryPortImpl.findPricesByDate(35455, 1, new Date());

        assertEquals(Optional.of(List.of(price)), retrievedPrices);
    }

    @Test
    public void testFindPricesByDate_noPricesFound() {
        when(priceDataRepository.findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(35455, 1, new Date()))
                .thenReturn(Optional.empty());

        Optional<List<Price>> retrievedPrices = priceDataRepositoryPortImpl.findPricesByDate(35455, 1, new Date());

        assertEquals(Optional.empty(), retrievedPrices);
    }
}