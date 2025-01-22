package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
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
public class GetPricesImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private GetPricesImpl getPricesImpl;

    @Test
    public void testGetPrices() {
        // Datos de prueba
        int productId = 35455;
        List<Price> prices = List.of(
                new Price(1, new Date(), new Date(), 1, productId, 0, 35.50, "EUR"),
                new Price(1, new Date(), new Date(), 2, productId, 1, 25.45, "EUR")
        );

        // Configurar el mock
        when(priceRepositoryPort.getPrices(productId)).thenReturn(Optional.of(prices));

        // Ejecutar el método
        Optional<List<Price>> actualPrices = getPricesImpl.getPrices(productId);

        // Verificar el resultado
        assertEquals(Optional.of(prices), actualPrices);
    }

    @Test
    public void testGetPrices_noPricesFound() {
        // Datos de prueba
        int productId = 35455;

        // Configurar el mock
        when(priceRepositoryPort.getPrices(productId)).thenReturn(Optional.empty());

        // Ejecutar el método
        Optional<List<Price>> actualPrices = getPricesImpl.getPrices(productId);

        // Verificar el resultado
        assertEquals(Optional.empty(), actualPrices);
    }
}
