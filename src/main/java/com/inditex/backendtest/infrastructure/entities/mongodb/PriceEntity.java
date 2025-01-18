package com.inditex.backendtest.infrastructure.entities.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Entidad que representa un precio en la base de datos MongoDB.
 */
@Document("prices")
public class PriceEntity {

    @Id
    private String id;

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

    /**
     * Constructor vacío.
     */
    public PriceEntity() {
    }

    /**
     * Constructor con todos los campos.
     *
     * @param brandId    Identificador de la cadena del grupo.
     * @param startDate  Fecha de inicio del rango de aplicación del precio.
     * @param endDate    Fecha de fin del rango de aplicación del precio.
     * @param priceList  Identificador de la tarifa de precios aplicable.
     * @param productId  Identificador del producto.
     * @param priority   Prioridad del precio.
     * @param price      Precio final de venta.
     * @param currency   ISO de la moneda.
     */
    public PriceEntity(
            int brandId,
            Date startDate,
            Date endDate,
            int priceList,
            int productId,
            int priority,
            double price,
            String currency) {

        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    /**
     * @return El identificador único del documento.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id El identificador único del documento.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return El identificador de la cadena del grupo.
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * @param brandId El identificador de la cadena del grupo.
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * @return La fecha de inicio del rango de aplicación del precio.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate La fecha de inicio del rango de aplicación del precio.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return La fecha de fin del rango de aplicación del precio.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate La fecha de fin del rango de aplicación del precio.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return El identificador de la tarifa de precios aplicable.
     */
    public int getPriceList() {
        return priceList;
    }

    /**
     * @param priceList El identificador de la tarifa de precios aplicable.
     */
    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    /**
     * @return El identificador del producto.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId El identificador del producto.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return La prioridad del precio.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority La prioridad del precio.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return El precio final de venta.
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price El precio final de venta.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return El ISO de la moneda.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency El ISO de la moneda.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
