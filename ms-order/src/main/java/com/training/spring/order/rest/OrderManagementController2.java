package com.training.spring.order.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.order.rest.models.OrderRestObj;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController2 {

    @PutMapping
    public void placeOrder(final OrderRestObj order) {
    }

    @DeleteMapping
    public void cancel() {

    }

}
