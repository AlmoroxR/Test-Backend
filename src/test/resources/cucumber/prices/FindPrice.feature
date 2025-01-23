Feature: Consultar precio final

  Scenario: Consultar precio con éxito (Test 1)
    Given el producto con id "35455", la marca con id "1" y la fecha "2020-06-14-10.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 200
    And el precio final es 35
    And la moneda es "EUR"

  Scenario: Consultar precio con éxito (Test 2)
    Given el producto con id "35455", la marca con id "1" y la fecha "2020-06-14-16.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 200
    And el precio final es 25
    And la moneda es "EUR"

  Scenario: Consultar precio con éxito (Test 3)
    Given el producto con id "35455", la marca con id "1" y la fecha "2020-06-14-21.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 200
    And el precio final es 35
    And la moneda es "EUR"

  Scenario: Consultar precio con éxito (Test 4)
    Given el producto con id "35455", la marca con id "1" y la fecha "2020-06-15-10.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 200
    And el precio final es 30
    And la moneda es "EUR"

  Scenario: Consultar precio con éxito (Test 5)
    Given el producto con id "35455", la marca con id "1" y la fecha "2020-06-16-21.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 200
    And el precio final es 38
    And la moneda es "EUR"

  Scenario: Consultar precio sin éxito (producto no encontrado)
    Given el producto con id "00000", la marca con id "1" y la fecha "2020-06-14-10.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 404

  Scenario: Consultar precio sin éxito (marca no encontrada)
    Given el producto con id "35455", la marca con id "00000" y la fecha "2020-06-14-10.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 404

  Scenario: Consultar precio sin éxito (fecha fuera de rango)
    Given el producto con id "35455", la marca con id "1" y la fecha "2024-01-26-15.00.00"
    When se consulta el precio final
    Then el código de respuesta HTTP es 404