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
public class FindFinalPriceImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private FindFinalPriceImpl findFinalPriceImpl;

    @Test
    public void testFindFinalPrice() {
        // Datos de prueba
        int productId = 35455;
        int brandId = 1;
        Date date = new Date();
        List<Price> prices = List.of(
                new Price(brandId, date, date, 1, productId, 0, 35.50, "EUR"),
                new Price(brandId, date, date, 2, productId, 1, 25.45, "EUR")
        );
        Price expectedPrice = prices.get(1); // El precio con mayor prioridad

        // Configurar el mock
        when(priceRepositoryPort.findPricesByDate(productId, brandId, date)).thenReturn(Optional.of(prices));

        // Ejecutar el método
        Optional<Price> actualPrice = findFinalPriceImpl.findFinalPrice(productId, brandId, date);

        // Verificar el resultado
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    public void testFindFinalPrice_noPricesFound() {
        // Datos de prueba
        int productId = 35455;
        int brandId = 1;
        Date date = new Date();

        // Configurar el mock
        when(priceRepositoryPort.findPricesByDate(productId, brandId, date)).thenReturn(Optional.empty());

        // Ejecutar el método
        Optional<Price> actualPrice = findFinalPriceImpl.findFinalPrice(productId, brandId, date);

        // Verificar el resultado
        assertEquals(Optional.empty(), actualPrice);
    }
}
