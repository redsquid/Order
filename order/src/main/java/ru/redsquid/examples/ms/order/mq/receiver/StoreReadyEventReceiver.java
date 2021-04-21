package ru.redsquid.examples.ms.order.mq.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.order.service.OrderService;
import ru.redsquid.examples.ms.store.queue.message.ReadyEvent;

@Component
@RequiredArgsConstructor
class StoreReadyEventReceiver {

    private final OrderService service;

    @RabbitListener(queues = Constants.STORE_READY_EVENT_QUEUE)
    public void receive(ReadyEvent event) {
        System.out.println("StoreReadyEventReceiver: " + event);
        service.updateReadyState(event.getOrderId());
    }
}
