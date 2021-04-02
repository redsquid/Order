package ru.redsquid.examples.ms.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.constants.QueueName;

@Component
@RequiredArgsConstructor
class StoreAcceptationCommandSender {

    private final RabbitTemplate rabbitTemplate;

    public void send(StoreAcceptationCommand command) {
        rabbitTemplate.convertAndSend(QueueName.STORE_ACCEPTATION_COMMAND, command);
    }
}
