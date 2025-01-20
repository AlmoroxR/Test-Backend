package com.inditex.backendtest.infrastructure.repositories.h2;

import com.inditex.backendtest.infrastructure.entities.h2.PriceEntity;
import com.inditex.backendtest.infrastructure.repositories.h2.queries.PriceQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio de datos para la entidad Price.
 * Extiende JpaRepository para proporcionar operaciones CRUD básicas y define métodos adicionales para consultas específicas.
 */
@Repository
public interface PriceDataRepository extends JpaRepository<PriceEntity, String> {

    /**
     * Busca precios por ID de producto.
     *
     * @param productId ID del producto.
     * @return Optional que contiene una lista de entidades PriceEntity, o vacío si no se encuentran precios.
     */
    Optional<List<PriceEntity>> findPricesByProductId(int productId);

    /**
     * Busca precios por ID de producto, ID de marca y fecha.
     *
     * @param productId ID del producto.
     * @param brandId   ID de la marca.
     * @param date      Fecha para la cual se buscan los precios.
     * @return Optional que contiene una lista de entidades PriceEntity, o vacío si no se encuentran precios.
     */
    @Query(PriceQueries.FIND_PRICES_BY_PRODUCT_ID_AND_BRAND_ID_AND_DATE)
    Optional<List<PriceEntity>> findPricesByProductIdAndBrandIdAndDateBetweenStartDateAndEndDate(
            @Param("productId") int productId, @Param("brandId") int brandId, @Param("date") Date date);
}
