package com.training.spring.order.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.order.rest.models.OrderRestObj;

@RestController
@RequestMapping("/api/v1/order/query")
public class OrderQueryController {


    @GetMapping("/get/order/info")
    public String getInfo() {
        return "OK";
    }

    @GetMapping("/get/all/orders")
    public List<OrderRestObj> getAll() {
        return null;
    }

}
