package ru.redsquid.examples.ms.order.mq.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingEvent;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.order.service.OrderService;

@Component
@RequiredArgsConstructor
class AccountingInvoicingReceiver {

    private final OrderService service;

    @RabbitListener(queues = Constants.ACCOUNTING_INVOICING_EVENT_QUEUE)
    public void receive(InvoicingEvent event) {
        System.out.println("AccountingInvoicingReceiver: " + event);
        service.updateInvoicedState(event.getOrderId());
    }
}
