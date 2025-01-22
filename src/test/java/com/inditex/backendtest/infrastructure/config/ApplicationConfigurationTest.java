package com.inditex.backendtest.infrastructure.config;

import com.inditex.backendtest.application.prices.CreatePriceImpl;
import com.inditex.backendtest.application.prices.FindFinalPriceImpl;
import com.inditex.backendtest.application.prices.GetPricesImpl;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import com.inditex.backendtest.infrastructure.repositories.h2.PriceDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ApplicationConfigurationTest {

    @Mock
    private ApplicationContext applicationContext;

    @Test
    public void testBeansAreCreated() {
        ApplicationConfiguration configuration = new ApplicationConfiguration();

        // Simular la inyección de dependencias
        PriceDataRepository priceDataRepository = mock(PriceDataRepository.class);
        PriceMapper priceMapper = mock(PriceMapper.class);
        PriceRepositoryPort priceRepositoryPort = configuration.priceRepositoryPort(priceDataRepository, priceMapper);

        // Verificar que los beans se crean correctamente
        assertNotNull(configuration.getPrices(priceRepositoryPort));
        assertNotNull(configuration.createPrice(priceRepositoryPort));
        assertNotNull(configuration.findPrices(priceRepositoryPort));
        assertNotNull(configuration.priceService(
                new CreatePriceImpl(priceRepositoryPort),
                new FindFinalPriceImpl(priceRepositoryPort),
                new GetPricesImpl(priceRepositoryPort)
        ));
        assertNotNull(configuration.priceMapper());
        assertNotNull(priceRepositoryPort);
    }
}