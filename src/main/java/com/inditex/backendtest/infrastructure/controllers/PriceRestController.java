package com.inditex.backendtest.infrastructure.controllers;

import com.inditex.backendtest.application.services.PricesService;
import com.inditex.backendtest.domain.model.Price;
import com.inditex.backendtest.infrastructure.entities.rest.PriceDto;
import com.inditex.backendtest.infrastructure.exceptions.prices.PriceNotFoundException;
import com.inditex.backendtest.infrastructure.mappers.PriceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/prices")
@Tag(
        name = "Precios",
        description = "Operaciones relacionadas con los precios"
)
public class PriceRestController {

    private final PricesService pricesService;
    private final PriceMapper priceMapper;

    public PriceRestController(PricesService pricesService, PriceMapper priceMapper) {
        this.pricesService = pricesService;
        this.priceMapper = priceMapper;
    }

    /**
     * Crea un nuevo precio.
     *
     * @param priceDto DTO con la información del precio a crear.
     * @return ResponseEntity con el Price creado y HttpStatus.CREATED.
     */
    @PostMapping
    @Operation(
            summary = "Crea un precio",
            description = "Crea un precio para un producto y una marca"
    )
    public ResponseEntity<Price> createPrice(@Valid @RequestBody PriceDto priceDto) {

        Price createdPrice = pricesService.createPrice(priceMapper.priceDtoToPriceDomain(priceDto));
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }

    /**
     * Obtiene los precios de un producto.
     *
     * @param id Identificador del producto.
     * @return ResponseEntity con una lista de PriceDto si se encuentran precios, o HttpStatus.NOT_FOUND si no se encuentran.
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Obtiene los precios",
            description = "Obtiene los precios de un producto a partir de su identificador"
    )
    public ResponseEntity <List<PriceDto>> getPrices(@NotNull @PathVariable int id) {

        return pricesService.getPrices(id)
                .map(prices -> {
                    // Convierte la lista de precios del dominio a DTOs.
                    List<PriceDto> priceDtos = prices.stream()
                            .map(priceMapper::priceDomainToPriceDto)
                            .toList();
                    // Devuelve una respuesta con la lista de DTOs y HttpStatus.OK.
                    return new ResponseEntity<>(priceDtos, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Busca el precio final para un producto y una marca en una fecha concreta.
     *
     * @param productId Identificador del producto.
     * @param brandId   Identificador de la marca.
     * @param date      Fecha y hora de la consulta.
     * @return ResponseEntity con el PriceDto encontrado y HttpStatus.OK, o lanza PriceNotFoundException si no se encuentra.
     */
    @GetMapping("/find")
    @Operation(
            summary = "Busca un precio",
            description = "Busca el precio final para un producto y una marca en una fecha concreta, y aplica el precio vigente en ese momento",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Precio encontrado", content = @Content(schema = @Schema(implementation = PriceDto.class))),
                    @ApiResponse(responseCode = "404", description = "Precio no encontrado")
    })
    public ResponseEntity <PriceDto> findFinalPrice(
            @Parameter(description = "Identificador del producto")  @NotNull @RequestParam int productId,
            @Parameter(description = "Identificador de la marca")   @NotNull @RequestParam int brandId,
            @Parameter(description = "Fecha y hora de la consulta") @NotNull @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date date
    ) {

        return pricesService.findFinalPrice(productId, brandId, date)
                .map(price -> new ResponseEntity<>(priceMapper.priceDomainToPriceDto(price), HttpStatus.OK))
                .orElseThrow(PriceNotFoundException::new);
    }
}
