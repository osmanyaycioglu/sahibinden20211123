package com.training.spring.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.live.error.ErrorObj;
import com.training.spring.order.clients.MyErrorException;
import com.training.spring.order.mappers.OrderMapper;
import com.training.spring.order.rest.models.OrderRestObj;
import com.training.spring.order.service.OrderManagementService;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @Autowired
    private OrderManagementService oms;

    @PostMapping("/place")
    public String placeOrder(@Validated @RequestBody final OrderRestObj order) throws MyErrorException {
        return this.oms.placeOrder(OrderMapper.toOrder(order));
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "OK";
    }

    @ExceptionHandler(MyErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public ErrorObj handleError(final MyErrorException exceptionParam) {
        return new ErrorObj().setMessage("error while calling another ms")
                             .setCause(3800)
                             .add(exceptionParam.getErrorObj());
    }


}
