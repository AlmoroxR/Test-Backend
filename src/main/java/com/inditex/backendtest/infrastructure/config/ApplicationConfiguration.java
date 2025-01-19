package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.prices.CreatePriceImpl;
import com.inditex.backendtest.application.prices.FindFinalPriceImpl;
import com.inditex.backendtest.application.prices.GetPricesImpl;
import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import com.inditex.backendtest.infrastructure.repositories.h2.PriceDataRepository;
import com.inditex.backendtest.infrastructure.repositories.h2.PriceDataRepositoryPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public GetPrices getPrices(PriceRepositoryPort priceRepositoryPort) {
        return new GetPricesImpl(priceRepositoryPort);
    }

    @Bean
    public CreatePrice createPrice(PriceRepositoryPort priceRepositoryPort) {
        return new CreatePriceImpl(priceRepositoryPort);
    }

    @Bean
    public FindFinalPrice findPrices(PriceRepositoryPort priceRepositoryPort) {
        return new FindFinalPriceImpl(priceRepositoryPort);
    }

    @Bean
    public PricesService priceService(CreatePrice createPrice, FindFinalPrice findFinalPrice, GetPrices getPrices) {
        return new PricesService(createPrice, findFinalPrice, getPrices);
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceDataRepository priceDataRepository) {
        return new PriceDataRepositoryPortImpl(priceDataRepository);
    }
}
