package com.training.spring.order.models;

import java.util.List;

import com.training.spring.restaurant.rest.models.Meal;

public class Order {

    private String     name;
    private String     surname;
    private String     phone;
    private List<Meal> meals;
    private Integer    hour;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }

    public Integer getHour() {
        return this.hour;
    }

    public void setHour(final Integer hourParam) {
        this.hour = hourParam;
    }


}
