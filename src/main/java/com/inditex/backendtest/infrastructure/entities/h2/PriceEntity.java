package com.inditex.backendtest.infrastructure.entities.h2;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Entidad que representa un precio en la base de datos.
 */
@Entity
@Table(name = "prices")
public class PriceEntity {

    /**
     * Identificador único de la entidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

    /**
     * Constructor vacío de la entidad PriceEntity.
     */
    public PriceEntity() {
        // Constructor vacío requerido por JPA
    }

    /**
     * Constructor de la entidad PriceEntity.
     *
     * @param brandId    Identificador de la marca.
     * @param startDate  Fecha de inicio de aplicación del precio.
     * @param endDate    Fecha de fin de aplicación del precio.
     * @param priceList  Identificador de la lista de precios.
     * @param productId  Identificador del producto.
     * @param priority   Prioridad del precio.
     * @param price      Valor del precio.
     * @param currency   Moneda del precio.
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
     * @return ID de la entidad.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id ID de la entidad.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Identificador de la marca.
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * @param brandId Identificador de la marca.
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * @return Fecha de inicio.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate Fecha de inicio.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Fecha de fin.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate Fecha de fin.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return Identificador de la lista de precios.
     */
    public int getPriceList() {
        return priceList;
    }

    /**
     * @param priceList Identificador de la lista de precios.
     */
    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    /**
     * @return Identificador del producto.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId Identificador del producto.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return Prioridad del precio.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority Prioridad del precio.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return Valor del precio.
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price Valor del precio.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return Moneda del precio.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency Moneda del precio.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "PriceEntity{" +
                "id=" + id +
                ", brandId=" + brandId +
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
