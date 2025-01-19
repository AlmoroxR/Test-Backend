package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PriceService;
import com.inditex.backendtest.domain.model.Price;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {

        Price createdPrice = priceService.createPrice(price);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<Price>> getPrices(@PathVariable int id) {

        return priceService.getPrices(id)
                .map(prices -> new ResponseEntity<>(prices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find")
    public ResponseEntity <Price> findPrices(
            @RequestParam int productId,
            @RequestParam int brandId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date
    ) {

        return priceService.findPrices(productId, brandId, date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
