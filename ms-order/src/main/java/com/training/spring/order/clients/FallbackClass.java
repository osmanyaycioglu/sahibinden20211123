package com.training.spring.order.clients;

import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

public class FallbackClass implements IRestaurantApi {

    @Override
    public MenuInfo calculateMenu(final MenuRestObj menuRestObjParam) {
        return new MenuInfo();
    }

}
