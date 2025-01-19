package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.prices.CreatePriceImpl;
import com.inditex.backendtest.application.prices.FindPricesImpl;
import com.inditex.backendtest.application.prices.GetPricesImpl;
import com.inditex.backendtest.application.services.CreatePriceService;
import com.inditex.backendtest.application.services.FindPricesService;
import com.inditex.backendtest.application.services.GetPricesService;
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
    public CreatePriceService createPriceService(CreatePrice createPrice) {
        return new CreatePriceService(createPrice);
    }

    @Bean
    public GetPricesService getPricesService(GetPrices getPrices) {
        return new GetPricesService(getPrices);
    }

    @Bean
    public FindPricesService findPricesService(FindPrices findPrices) {
        return new FindPricesService(findPrices);
    }

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceDataRepository priceDataRepository) {
        return new PriceDataRepositoryPortImpl(priceDataRepository);
    }
}
