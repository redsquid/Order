package ru.redsquid.examples.ms.order.mq.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.order.service.OrderService;
import ru.redsquid.examples.ms.store.queue.message.AcceptationEvent;

@Component
@RequiredArgsConstructor
class StoreAcceptationEventReceiver {

    private final OrderService service;

    @RabbitListener(queues = Constants.STORE_ACCEPTATION_EVENT_QUEUE)
    public void receive(AcceptationEvent event) {
        System.out.println("StoreAcceptationEventReceiver: " + event);
        service.updateAcceptationState(event.getOrderId(), event.isAccepted());
    }
}
