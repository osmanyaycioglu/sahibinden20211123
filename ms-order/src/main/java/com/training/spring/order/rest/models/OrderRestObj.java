package com.training.spring.order.rest.models;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.training.spring.validation.StartWith;

public class OrderRestObj {

    @NotEmpty
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String            name;
    @NotEmpty
    @Size(min = 3, max = 20, message = "surname {min} ile {max} arasında olmalı")
    @StartWith("s:")
    private String            surname;
    @NotEmpty
    @Size(min = 10, max = 10, message = "phone 10 hane olmalı")
    private String            phone;
    @Size(min = 1, message = "order da min 1 tane yemek olmalı")
    private List<MealRestObj> meals;
    @NotNull
    @Max(12)
    @Min(1)
    private Integer           hour;

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

    public List<MealRestObj> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<MealRestObj> mealsParam) {
        this.meals = mealsParam;
    }

    public Integer getHour() {
        return this.hour;
    }

    public void setHour(final Integer hourParam) {
        this.hour = hourParam;
    }


}
