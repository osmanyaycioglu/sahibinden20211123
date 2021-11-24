package com.training.spring.order.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.order.rest.models.OrderRestObj;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @PostMapping("/place")
    public String placeOrder(@Validated @RequestBody final OrderRestObj order) {
        return "OK";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "OK";
    }

}
