package com.inditex.backendtest.application.prices;

import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.domain.ports.out.PriceRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreatePriceImplTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;

    @InjectMocks
    private CreatePriceImpl createPriceImpl;

    @Test
    public void testCreatePrice() {
        // Datos de prueba
        Price price = new Price(1, new Date(), new Date(), 1, 35455, 0, 35.50, "EUR");

        // Configurar el mock
        when(priceRepositoryPort.savePrice(price)).thenReturn(price);

        // Ejecutar el método
        Price createdPrice = createPriceImpl.createPrice(price);

        // Verificar el resultado
        assertEquals(price, createdPrice);
    }
}
