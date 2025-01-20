package com.inditex.backendtest.infrastructure.entities.rest;

import java.util.Date;

/**
 * Se utiliza para transferir datos entre capas de la aplicación.
 */
public class PriceDto {

    private int productId;
    private int brandId;
    private int priceList;
    private Date startDate;
    private Date endDate;
    private Long price;
    private String currency;

    /**
     * Constructor vacío de la clase PriceDto.
     */
    public PriceDto() {
    }

    /**
     * Constructor de la clase PriceDto.
     *
     * @param productId  Identificador del producto.
     * @param brandId    Identificador de la marca.
     * @param priceList  Identificador de la lista de precios.
     * @param startDate  Fecha de inicio de la aplicación del precio.
     * @param endDate    Fecha de fin de la aplicación del precio.
     * @param price      Valor del precio.
     * @param currency   Moneda del precio.
     */
    public PriceDto(
            int productId,
            int brandId,
            int priceList,
            Date startDate,
            Date endDate,
            Long price,
            String currency) {

        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
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
     * @return Valor del precio.
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price Valor del precio.
     */
    public void setPrice(Long price) {
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
        return "PriceDto{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", priceList=" + priceList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}