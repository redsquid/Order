package ru.redsquid.examples.ms.order.mq.store;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.constants.QueueName;
import ru.redsquid.examples.ms.order.service.OrderService;

@Component
@RequiredArgsConstructor
class StoreAcceptationEventReceiver {

    private final OrderService service;

    @RabbitListener(queues = QueueName.STORE_ACCEPTATION_EVENT)
    public void receive(StoreAcceptationEvent event) {
        service.updateAcceptationState(event.getOrderId(), event.isAccepted());
    }
}
