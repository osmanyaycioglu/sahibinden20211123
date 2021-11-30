package com.training.spring.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.clients.MyErrorException;
import com.training.spring.order.clients.RestaurantClient;
import com.training.spring.order.models.Order;

@Service
public class OrderManagementService {

    @Autowired
    private RestaurantClient rc;

    public String placeOrder(final Order orderParam) throws MyErrorException {
        return this.rc.calculateMenu2(orderParam);
    }
}
