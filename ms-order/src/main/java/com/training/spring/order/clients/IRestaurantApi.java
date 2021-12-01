package com.training.spring.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.live.error.MyErrorException;
import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

@FeignClient(name = "RESTAURANT-API")
public interface IRestaurantApi {

    @PostMapping("/api/v1/restaurant/management/calculate/menu")
    public MenuInfo calculateMenu(@RequestBody final MenuRestObj menuRestObjParam) throws MyErrorException;

}
