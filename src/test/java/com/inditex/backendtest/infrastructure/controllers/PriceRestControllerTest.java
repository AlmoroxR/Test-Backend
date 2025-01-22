package com.inditex.backendtest.infrastructure.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

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
        mockMvc.perform(get("/v1/prices/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindFinalPrice() throws Exception {
        mockMvc.perform(get("/v1/prices/find")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14-10.00.00"))
                .andExpect(status().isOk());
    }
}