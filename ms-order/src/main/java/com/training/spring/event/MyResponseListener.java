package com.training.spring.event;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MyResponseListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue-response",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "response-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "sms-reponse"))
    public void consumeSMSEvent(final String str) {
        System.out.println("SMS Response Received Event : " + str);
    }

}
