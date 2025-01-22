package com.inditex.backendtest.application.prices.services;

import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.in.CreatePrice;
import com.inditex.backendtest.domain.ports.in.FindFinalPrice;
import com.inditex.backendtest.domain.ports.in.GetPrices;
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
public class PricesServiceTest {

    @Mock
    private CreatePrice createPrice;

    @Mock
    private FindFinalPrice findFinalPrice;

    @Mock
    private GetPrices getPrices;

    @InjectMocks
    private PricesService pricesService;

    @Test
    public void testCreatePrice() {
        // Datos de prueba
        Price price = new Price(1, new Date(), new Date(), 1, 35455, 0, 35.50, "EUR");

        // Configurar el mock
        when(createPrice.createPrice(price)).thenReturn(price);

        // Ejecutar el metodo
        Price createdPrice = pricesService.createPrice(price);

        // Verificar el resultado
        assertEquals(price, createdPrice);
    }

    @Test
    public void testFindFinalPrice() {
        // Datos de prueba
        int productId = 35455;
        int brandId = 1;
        Date date = new Date();
        Price expectedPrice = new Price(brandId, date, date, 1, productId, 0, 35.50, "EUR");

        // Configurar el mock
        when(findFinalPrice.findFinalPrice(productId, brandId, date)).thenReturn(Optional.of(expectedPrice));

        // Ejecutar el metodo
        Optional<Price> actualPrice = pricesService.findFinalPrice(productId, brandId, date);

        // Verificar el resultado
        assertEquals(Optional.of(expectedPrice), actualPrice);
    }

    @Test
    public void testGetPrices() {
        // Datos de prueba
        int productId = 35455;
        List<Price> prices = List.of(
                new Price(1, new Date(), new Date(), 1, productId, 0, 35.50, "EUR"),
                new Price(1, new Date(), new Date(), 2, productId, 1, 25.45, "EUR")
        );

        // Configurar el mock
        when(getPrices.getPrices(productId)).thenReturn(Optional.of(prices));

        // Ejecutar el metodo
        Optional<List<Price>> actualPrices = pricesService.getPrices(productId);

        // Verificar el resultado
        assertEquals(Optional.of(prices), actualPrices);
    }
}
