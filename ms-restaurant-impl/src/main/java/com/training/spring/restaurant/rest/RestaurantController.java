package com.training.spring.restaurant.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

@RestController
public class RestaurantController implements IRestaurantRest {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @Value("${server.port}")
    private int                 port;

    @Override
    public MenuInfo calculateMenu(final MenuRestObj menuRestObjParam) {
        if (RestaurantController.logger.isInfoEnabled()) {
            RestaurantController.logger.info("[RestaurantController][calculateMenu]-> Received : " + menuRestObjParam);
        }
        MenuInfo infoLoc = new MenuInfo();
        infoLoc.setPrice(100);
        infoLoc.setMessage("Port : " + this.port);
        return infoLoc;
    }

}
