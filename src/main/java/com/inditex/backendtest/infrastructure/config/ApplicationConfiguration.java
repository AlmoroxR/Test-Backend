package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.price.CreatePriceImpl;
import com.inditex.backendtest.application.price.GetPricesImpl;
import com.inditex.backendtest.application.services.PricesManagementService;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import com.inditex.backendtest.infrastructure.repositories.mongodb.PriceRepository;
import com.inditex.backendtest.infrastructure.repositories.mongodb.PriceRepositoryPortImpl;
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
    public PricesManagementService pricesManagementService(CreatePrice createPrice, GetPrices getPrices) {
        return new PricesManagementService(createPrice, getPrices);
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceRepository priceRepository) {
        return new PriceRepositoryPortImpl(priceRepository);
    }
}
