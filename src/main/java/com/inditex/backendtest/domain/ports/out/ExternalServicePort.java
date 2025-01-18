package com.inditex.backendtest.domain.ports.out;

import com.inditex.backendtest.domain.model.Price;

/**
 * Interfaz del puerto de salida para un servicio externo que proporciona precios.
 */
public interface ExternalServicePort {

    /**
     * Obtiene el precio de un producto de un servicio externo.
     *
     * @param brandId    El ID de la cadena.
     * @param productId  El ID del producto.
     * @param date       La fecha para la que se busca el precio.
     * @return          El precio del producto obtenido del servicio externo.
     */
    Price getPrice(int brandId, int productId, String date);
}
