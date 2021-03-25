package ru.redsquid.examples.ms.order.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "orders")
    public void receiveResponse(String message) {
        System.out.println("RECEIVED ORDER: " + message);
    }

    @RabbitListener(queues = "customers")
    public void receiveResponse1(String message) {
        System.out.println("RECEIVED CUSTOMER: " + message);
    }
}
