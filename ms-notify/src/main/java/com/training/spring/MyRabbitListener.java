package com.training.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", durable = "true", autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "sms-notification"))
    @SendTo("response-exchange/sms-reponse")
    public String consumeSMSEvent(final SendMessageEvent str) {
        System.out.println("SMS Received Event : " + str);
        return "SMS Sent to " + str.getDestination();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "mail-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "mail-notification"))
    public void consumeMailEvent(final SendMessageEvent str) {
        System.out.println("Mail Received Event : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-queue",
                                                            durable = "true",
                                                            autoDelete = "false"),
                                             exchange = @Exchange(name = "notfication-topic",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.notify.sms.#"))
    public void consumeTopicEvent(final SendMessageEvent str) {
        System.out.println("Mail Received Event : " + str);
    }

}
