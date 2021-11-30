package com.training.spring.restaurant.rest.models;


public class Meal {

    private String  meal;
    private Integer count;

    public String getMeal() {
        return this.meal;
    }

    public Meal setMeal(final String mealParam) {
        this.meal = mealParam;
        return this;
    }

    public Integer getCount() {
        return this.count;
    }

    public Meal setCount(final Integer countParam) {
        this.count = countParam;
        return this;
    }


}
