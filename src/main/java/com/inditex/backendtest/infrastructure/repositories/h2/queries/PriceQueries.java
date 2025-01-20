package com.inditex.backendtest.infrastructure.repositories.h2.queries;

/**
 * Clase que contiene las consultas JPQL utilizadas para acceder a los datos de precios.
 */
public class PriceQueries {

    /**
     * Consulta JPQL para buscar precios por ID de producto, ID de marca y fecha.
     */
    public static final String FIND_PRICES_BY_PRODUCT_ID_AND_BRAND_ID_AND_DATE = "SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.brandId = :brandId AND :date BETWEEN p.startDate AND p.endDate";
}
