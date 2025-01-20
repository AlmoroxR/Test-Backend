package com.inditex.backendtest.infrastructure.exceptions.prices;

public class DataAccessException extends RuntimeException {
    public DataAccessException(Throwable cause) {
        super("Error al obtener los precios de la base de datos", cause);
    }
}