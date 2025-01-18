package com.inditex.backendtest.domain.model;

import java.util.Date;

public class Price {

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

    /**
     * Constructor de la clase Prices.
     *
     * @param brandId    Identificador de la cadena.
     * @param startDate  Fecha de inicio de la vigencia del precio.
     * @param endDate    Fecha de fin de la vigencia del precio.
     * @param priceList  Identificador de la lista de precios.
     * @param productId  Identificador del producto.
     * @param priority   Prioridad del precio.
     * @param price      Precio del producto.
     * @param currency   Moneda del precio.
     */
    public Price(
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
     * @return El identificador de la cadena.
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * @param brandId El nuevo identificador de la cadena.
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * @return La fecha de inicio de la vigencia del precio.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate La nueva fecha de inicio de la vigencia del precio.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return La fecha de fin de la vigencia del precio.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate La nueva fecha de fin de la vigencia del precio.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return El identificador de la lista de precios.
     */
    public int getPriceList() {
        return priceList;
    }

    /**
     * @param priceList El nuevo identificador de la lista de precios.
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
     * @param productId El nuevo identificador del producto.
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
     * @param priority La nueva prioridad del precio.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return El precio del producto.
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price El nuevo precio del producto.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return La moneda del precio.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency La nueva moneda del precio.
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
