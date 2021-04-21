package ru.redsquid.examples.ms.order.mq.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.order.service.OrderService;
import ru.redsquid.examples.ms.store.queue.message.InProgressEvent;

@Component
@RequiredArgsConstructor
class StoreInProgressEventReceiver {

    private final OrderService service;

    @RabbitListener(queues = Constants.STORE_IN_PROGRESS_EVENT_QUEUE)
    public void receive(InProgressEvent event) {
        System.out.println("StoreInProgressEventReceiver: " + event);
        service.updateInProgressState(event.getOrderId());
    }
}
