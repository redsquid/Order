package ru.redsquid.examples.ms.order.mq.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.accounting.queue.message.PaidEvent;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.order.service.OrderService;

@Component
@RequiredArgsConstructor
class AccountingPaidEventReceiver {

    private final OrderService service;

    @RabbitListener(queues = Constants.ACCOUNTING_PAID_EVENT_QUEUE)
    public void receive(PaidEvent event) {
        System.out.println("AccountingPaidEventReceiver: " + event);
        service.updatePaidState(event.getOrderId());
    }
}
