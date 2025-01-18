package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PricesManagementService;
import com.inditex.backendtest.domain.model.Price;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PricesManagementService pricesManagementService;

    public PriceController(PricesManagementService pricesManagementService) {

        this.pricesManagementService = pricesManagementService;
    }

    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {

        Price createdPrice = pricesManagementService.createPrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<Price>> getPrice(@PathVariable int id) {

        return pricesManagementService.getPrices(id)
                .map(prices -> new ResponseEntity<>(prices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
