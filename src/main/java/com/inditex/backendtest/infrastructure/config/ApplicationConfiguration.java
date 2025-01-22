package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.prices.CreatePriceImpl;
import com.inditex.backendtest.application.prices.FindFinalPriceImpl;
import com.inditex.backendtest.application.prices.GetPricesImpl;
import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;

import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import com.inditex.backendtest.infrastructure.repositories.h2.PriceDataRepository;
import com.inditex.backendtest.infrastructure.repositories.h2.PriceDataRepositoryPortImpl;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración de la aplicación.
 * Define los beans que se utilizarán en la aplicación.
 */
@Configuration
public class ApplicationConfiguration {

    /**
     * Bean para el caso de uso de obtener los precios de un producto.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     * @return Implementación del caso de uso GetPrices.
     */
    @Bean
    public GetPrices getPrices(PriceRepositoryPort priceRepositoryPort) {
        return new GetPricesImpl(priceRepositoryPort);
    }

    /**
     * Bean para el caso de uso de crear un nuevo precio.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     * @return Implementación del caso de uso CreatePrice.
     */
    @Bean
    public CreatePrice createPrice(PriceRepositoryPort priceRepositoryPort) {
        return new CreatePriceImpl(priceRepositoryPort);
    }

    /**
     * Bean para el caso de uso de encontrar el precio final de un producto.
     *
     * @param priceRepositoryPort Puerto de salida para acceder al repositorio de precios.
     * @return Implementación del caso de uso FindFinalPrice.
     */
    @Bean
    public FindFinalPrice findPrices(PriceRepositoryPort priceRepositoryPort) {
        return new FindFinalPriceImpl(priceRepositoryPort);
    }

    /**
     * Bean para el servicio de precios.
     *
     * @param createPrice    Implementación del caso de uso para crear un precio.
     * @param findFinalPrice Implementación del caso de uso para encontrar el precio final.
     * @param getPrices      Implementación del caso de uso para obtener los precios.
     * @return Instancia del servicio PricesService.
     */
    @Bean
    public PricesService priceService(CreatePrice createPrice, FindFinalPrice findFinalPrice, GetPrices getPrices) {
        return new PricesService(createPrice, findFinalPrice, getPrices);
    }

    /**
     * Bean para el mapeador de precios.
     *
     * @return Instancia del mapeador PriceMapper.
     */
    @Bean
    public PriceMapper priceMapper() {
        return Mappers.getMapper(PriceMapper.class);
    }

    /**
     * Bean para el puerto de salida del repositorio de precios.
     *
     * @param priceDataRepository Repositorio de datos de precios.
     * @param priceMapper         Mapeador de precios.
     * @return Implementación del puerto de salida PriceRepositoryPort.
     */
    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceDataRepository priceDataRepository, PriceMapper priceMapper) {
        return new PriceDataRepositoryPortImpl(priceDataRepository, priceMapper);
    }

    @Bean
    public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}