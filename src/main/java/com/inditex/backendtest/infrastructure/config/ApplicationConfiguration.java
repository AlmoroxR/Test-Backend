package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.prices.CreatePriceImpl;
import com.inditex.backendtest.application.prices.FindPricesImpl;
import com.inditex.backendtest.application.prices.GetPricesImpl;
import com.inditex.backendtest.application.services.PriceService;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindPrices;
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
    public FindPrices findPrices(PriceRepositoryPort priceRepositoryPort) {
        return new FindPricesImpl(priceRepositoryPort);
    }

    @Bean
    public PriceService priceService(CreatePrice createPrice, FindPrices findPrices, GetPrices getPrices) {
        return new PriceService(createPrice, findPrices, getPrices);
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceDataRepository priceDataRepository) {
        return new PriceDataRepositoryPortImpl(priceDataRepository);
    }
}
