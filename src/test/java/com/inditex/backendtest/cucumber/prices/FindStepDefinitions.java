package com.inditex.backendtest.cucumber.prices;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindStepDefinitions {

    private RequestSpecification request;
    private Response response;
    private float price;

    @Given("el producto con id {string}, la marca con id {string} y la fecha {string}")
    public void elProductoConIdLaMarcaConIdYLaFecha(String productId, String brandId, String date) {
        request = given()
                .param("productId", productId)
                .param("brandId", brandId)
                .param("date", date);
    }

    @When("se consulta el precio final")
    public void seConsultaElPrecioFinal() {
        response = request.when().get("/v1/prices/find");
    }

    @Then("el código de respuesta HTTP es {int}")
    public void elCodigoDeRespuestaHTTPEs(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("el precio final es {float}")
    public void elPrecioFinalEs(float expectedPrice) {
        price = response.jsonPath().getFloat("price");
        assertEquals(expectedPrice, price, 0.001);
    }

    @Then("la moneda es {string}")
    public void laMonedaEs(String expectedCurrency) {
        String currency = response.jsonPath().getString("currency");
        assertEquals(expectedCurrency, currency);
    }
}
