package com.inditex.backendtest.domain;

import com.inditex.backendtest.domain.model.Price;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @Test
    public void testConstructorAndGetters() {
        Price price = createPrice();
        assertPrice(price, 1, getDate(2020, 6, 14, 0, 0, 0), getDate(2020, 12, 31, 23, 59, 59),
                1, 35455, 0, 35.50, "EUR");
    }

    @Test
    public void testSetters() {
        Price price = createPrice();

        price.setBrandId(2);
        price.setStartDate(getDate(2023, 1, 1, 0, 0, 0));
        price.setEndDate(getDate(2023, 12, 31, 23, 59, 59));
        price.setPriceList(2);
        price.setProductId(35456);
        price.setPriority(1);
        price.setPrice(25.45);
        price.setCurrency("USD");

        assertPrice(
                price, 2,
                getDate(2023, 1, 1, 0, 0, 0),
                getDate(2023, 12, 31, 23, 59, 59),
                2, 35456, 1, 25.45, "USD");
    }

    // Metodo auxiliar para crear una instancia de Price con datos de prueba
    private Price createPrice() {
        return new Price(1, getDate(2020, 6, 14, 0, 0, 0), getDate(2020, 12, 31, 23, 59, 59),
                1, 35455, 0, 35.50, "EUR");
    }

    // Metodo auxiliar para crear una instancia de Date
    private Date getDate(int year, int month, int day, int hour, int minute, int second) {
        return new Date(year - 1900, month - 1, day, hour, minute, second);
    }

    // Metodo auxiliar para realizar las aserciones
    private void assertPrice(Price price, int brandId, Date startDate, Date endDate, int priceList,
                             int productId, int priority, double priceValue, String currency) {
        assertEquals(brandId, price.getBrandId());
        assertEquals(startDate, price.getStartDate());
        assertEquals(endDate, price.getEndDate());
        assertEquals(priceList, price.getPriceList());
        assertEquals(productId, price.getProductId());
        assertEquals(priority, price.getPriority());
        assertEquals(priceValue, price.getPrice(), 0.001);
        assertEquals(currency, price.getCurrency());
    }
}
