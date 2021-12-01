package com.training.spring.order.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.live.error.MyErrorException;
import com.training.spring.order.clients.RestaurantClient;
import com.training.spring.order.models.Order;
import com.training.spring.order.models.SendMessageEvent;

@Service
public class OrderManagementService {

    @Autowired
    private RestaurantClient rc;

    @Autowired
    private RabbitTemplate   rt;

    public String placeOrder(final Order orderParam) throws MyErrorException {
        String calculateMenu2Loc = this.rc.calculateMenu2(orderParam);
        SendMessageEvent eventLoc = new SendMessageEvent();
        eventLoc.setDestination(orderParam.getPhone());
        eventLoc.setMessage(calculateMenu2Loc);
        eventLoc.setType(1);

        this.rt.convertAndSend("notfication-exchange",
                               "sms-notification",
                               eventLoc);
        this.rt.convertAndSend("notfication-topic",
                               "message.notify.sms.tr.restaurant",
                               eventLoc);
        return calculateMenu2Loc;
    }
}
