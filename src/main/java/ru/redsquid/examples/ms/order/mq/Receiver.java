package ru.redsquid.examples.ms.order.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.constants.QueueName;

@Component
public class Receiver {

    @RabbitListener(queues = QueueName.STORE_ACCEPTATION_COMMAND)
    public void receiveResponse1(String message) {
        System.out.println("RECEIVED ORDER: " + message);
    }
}
