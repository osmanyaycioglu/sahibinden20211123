package com.training.spring.restaurant.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

@RequestMapping("/api/v1/restaurant/management")
public interface IRestaurantRest {

    @PostMapping("/calculate/menu")
    public MenuInfo calculateMenu(@RequestBody final MenuRestObj menuRestObjParam);

}
