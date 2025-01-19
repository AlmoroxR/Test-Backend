package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.entities.rest.PriceDto;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import org.mapstruct.factory.Mappers;
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
    private final PriceMapper priceMapper;

    public PriceRestController(PricesService pricesService, PriceMapper priceMapper) {
        this.pricesService = pricesService;
        this.priceMapper = priceMapper;
    }

    @PostMapping
    public ResponseEntity<Price> createPrice(@RequestBody PriceDto priceDto) {

        Price createdPrice = pricesService.createPrice(priceMapper.priceDtoToPriceDomain(priceDto));
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <List<PriceDto>> getPrices(@PathVariable int id) {

        return pricesService.getPrices(id)
                .map(prices -> {
                    List<PriceDto> priceDtos = prices.stream()
                            .map(priceMapper::priceDomainToPriceDto)
                            .toList();
                    return new ResponseEntity<>(priceDtos, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find")
    public ResponseEntity <PriceDto> findFinalPrice(
            @RequestParam int productId,
            @RequestParam int brandId,
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date
    ) {

        return pricesService.findFinalPrice(productId, brandId, date)
                .map(price -> new ResponseEntity<>(priceMapper.priceDomainToPriceDto(price), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
