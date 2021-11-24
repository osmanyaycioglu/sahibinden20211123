package com.training.spring.order.rest.models;


public class MealRestObj {

    private String  meal;
    private Integer count;

    public String getMeal() {
        return this.meal;
    }

    public void setMeal(final String mealParam) {
        this.meal = mealParam;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(final Integer countParam) {
        this.count = countParam;
    }


}
