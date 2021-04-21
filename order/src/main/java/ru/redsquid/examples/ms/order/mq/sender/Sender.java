package ru.redsquid.examples.ms.order.mq.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.mq.constants.Constants;

@Component
@RequiredArgsConstructor
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    public void send(Object message, String key) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE, key, message);
    }
}
