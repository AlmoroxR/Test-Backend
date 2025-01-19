package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.model.Price;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceRestController {

    private final PricesService pricesService;

    public PriceRestController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {

        Price createdPrice = pricesService.createPrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<Price>> getPrices(@PathVariable int id) {

        return pricesService.getPrices(id)
                .map(prices -> new ResponseEntity<>(prices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find")
    public ResponseEntity <Price> findFinalPrice(
            @RequestParam int productId,
            @RequestParam int brandId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date
    ) {

        return pricesService.findFinalPrice(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
