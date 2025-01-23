package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PriceRestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @MockitoBean
    private PricesService pricesService;

    @MockitoBean
    private PriceMapper priceMapper;

    @Test
    public void testCreatePrice() throws Exception {
        mockMvc.perform(post("/v1/prices")
                        .contentType("application/json")
                        .content("{      \"brandId\": 1234,\n" +
                                "        \"startDate\": \"2020-06-15T14:00:00.000+00:00\",\n" +
                                "        \"endDate\": \"2020-12-31T22:59:59.000+00:00\",\n" +
                                "        \"priceList\": 1,\n" +
                                "        \"productId\": 1234,\n" +
                                "        \"priority\": 99,\n" +
                                "        \"price\": 38.95,\n" +
                                "        \"currency\": \"EUR\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetPrices() throws Exception {

        Price price = new Price(1, new Date(), new Date(), 1, 35455, 0, 35.50, "EUR");
        when(pricesService.getPrices(1)).thenReturn(Optional.of(List.of(price)));

        mockMvc.perform(get("/v1/prices/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice_scenario1() throws Exception {

        // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00");
        Price price = new Price(1, date, date, 1, 35455, 0, 35.50, "EUR");
        when(pricesService.findFinalPrice(35455, 1, date)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14-10.00.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice_scenario2() throws Exception {

        // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 16:00:00");
        Price price = new Price(2, date, date, 2, 35455, 1, 25.45, "EUR");
        when(pricesService.findFinalPrice(35455, 1, date)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14-16.00.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice_scenario3() throws Exception {

        // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 21:00:00");
        Price price = new Price(1, date, date, 1, 35455, 0, 35.50, "EUR");
        when(pricesService.findFinalPrice(35455, 1, date)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14-21.00.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice_scenario4() throws Exception {

        // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 10:00:00");
        Price price = new Price(3, date, date, 3, 35455, 1, 30.50, "EUR");
        when(pricesService.findFinalPrice(35455, 1, date)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-15-10.00.00"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice_scenario5() throws Exception {

        // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-16 21:00:00");
        Price price = new Price(4, date, date, 4, 35455, 1, 38.95, "EUR");
        when(pricesService.findFinalPrice(35455, 1, date)).thenReturn(Optional.of(price));

        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-16-21.00.00"))
                .andExpect(status().isOk());
    }

}