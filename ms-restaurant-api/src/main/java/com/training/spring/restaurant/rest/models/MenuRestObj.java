package com.training.spring.restaurant.rest.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class MenuRestObj {

    @NotNull
    private List<Meal> meals;
    @NotEmpty
    @Size(min = 5, max = 30)
    private String     menuname;

    public List<Meal> getMeals() {
        return this.meals;
    }


    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }


    public String getMenuname() {
        return this.menuname;
    }


    public void setMenuname(final String menunameParam) {
        this.menuname = menunameParam;
    }


}

