package com.training.spring.restaurant.rest.models;


public class MenuInfo {

    private Integer price;
    private String  message;

    public Integer getPrice() {
        return this.price;
    }


    public void setPrice(final Integer priceParam) {
        this.price = priceParam;
    }


    public String getMessage() {
        return this.message;
    }


    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }


}
