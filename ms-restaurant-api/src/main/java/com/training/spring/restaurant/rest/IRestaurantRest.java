package com.training.spring.restaurant.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

public interface IRestaurantRest {

    @PostMapping("/api/v1/restaurant/management/calculate/menu")
    public MenuInfo calculateMenu(@Validated @RequestBody final MenuRestObj menuRestObjParam);

}
