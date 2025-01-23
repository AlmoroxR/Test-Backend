# Prueba Técnica Backend - Gestión de Precios

Este proyecto es una prueba técnica que implementa un backend REST para la gestión de precios.

## Características principales

*   **SpringBoot:** El proyecto está desarrollado utilizando SpringBoot.
*   **Arquitectura Hexagonal:** Se ha implementado una arquitectura hexagonal para asegurar la modularidad y escalabilidad del código.
*   **Base de Datos en Memoria:** Se utiliza una base de datos SQL en memoria (H2) para facilitar la ejecución y el despliegue.
*   **Test Unitarios e de Integración:** Se han incluido test unitarios y de integración para asegurar la calidad del código y cumplir con los requisitos de la prueba.

## Requisitos de la Prueba

Se ha asegurado de que se cumplen los siguientes casos de prueba:

*   Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
*   Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
*   Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
*   Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
*   Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)

## Tests

Se han agregado tests end to end utilizando Cucumber y RestAssured, aprovechando mi experiencia previa con estas herramientas. Se han utilizado para probar el endpoint de consulta de un precio, asegurando que la API REST funciona correctamente.

Cucumber permite escribir tests en un lenguaje natural (Gherkin), lo que facilita su comprensión y promueve la colaboración entre el equipo de desarrollo y el equipo de negocio. Además, Cucumber genera documentación a partir de los escenarios de prueba, lo que ayuda a comprender el comportamiento del sistema.

Para ver los reportes de Cucumber, puedes acceder a la URL que se muestra en la consola al ejecutar los tests de la clase `CucumberRunner.java`. También puedes abrir el archivo `target/cucumber-report.html` en tu navegador web.

## Funcionalidades Adicionales

Además de la funcionalidad principal de la prueba, se han implementado dos operaciones básicas:

*   Obtener todos los precios de un producto
*   Crear un nuevo precio

Estas funcionalidades se añadieron para demostrar la escalabilidad del código y la capacidad de añadir nuevas funcionalidades sin afectar a las existentes.

## Cómo Replicar el Proyecto

1.  Clonar el repositorio en un IDE compatible con Java.
2.  Ejecutar el proyecto con un servidor de aplicaciones local. La base de datos se creará automáticamente en memoria a partir del fichero data.sql.
3.  Utilizar un cliente REST como Postman o Thunder Client para realizar llamadas al API.

## Ejemplos de Llamadas al API
*   POST  - localhost:8080/v1/prices
*   GET   - localhost:8080/v1/prices/35455
*   GET   - localhost:8080/v1/prices/find?brandId=1&date=2020-12-31-23.59.59&productId=1

## Documentación del API

La documentación del API está disponible en:

[Documentación Swagger](http://localhost:8080/swagger-ui/index.html)
