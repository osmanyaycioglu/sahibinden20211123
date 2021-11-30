package com.training.spring.restaurant.rest.models;

import java.util.List;


public class MenuRestObj {

    private List<Meal> meals;


    public List<Meal> getMeals() {
        return this.meals;
    }


    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }


}

