package com.training.spring.order.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.live.error.MyErrorException;
import com.training.spring.order.models.Order;
import com.training.spring.restaurant.rest.models.MenuInfo;
import com.training.spring.restaurant.rest.models.MenuRestObj;

@Service
public class RestaurantClient {

    @Autowired
    private RestTemplate   rt;

    @Autowired
    private IRestaurantApi restaurantApi;

    public String calculateMenu(final Order orderParam) {
        MenuRestObj menuRestObjLoc = new MenuRestObj();
        menuRestObjLoc.setMeals(orderParam.getMeals());
        List<ClientHttpRequestInterceptor> interceptorsLoc = this.rt.getInterceptors();
        for (ClientHttpRequestInterceptor clientHttpRequestInterceptorLoc : interceptorsLoc) {
            System.out.println("Inter : "
                               + clientHttpRequestInterceptorLoc.getClass()
                                                                .getName());
        }
        MenuInfo menuInfoLoc = this.rt.postForObject("http://RESTAURANT/api/v1/restaurant/management/calculate/menu",
                                                     menuRestObjLoc,
                                                     MenuInfo.class);
        return "Port : " + menuInfoLoc.getMessage() + " Price : " + menuInfoLoc.getPrice();

    }

    public String calculateMenu2(final Order orderParam) throws MyErrorException {
        MenuRestObj menuRestObjLoc = new MenuRestObj();
        menuRestObjLoc.setMeals(orderParam.getMeals());
        menuRestObjLoc.setMenuname(orderParam.getName());
        MenuInfo menuInfoLoc = this.restaurantApi.calculateMenu(menuRestObjLoc);
        return "Port : " + menuInfoLoc.getMessage() + " Price : " + menuInfoLoc.getPrice();
    }

}
