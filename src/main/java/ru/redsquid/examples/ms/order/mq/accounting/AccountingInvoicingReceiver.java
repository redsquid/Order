package ru.redsquid.examples.ms.order.mq.accounting;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.constants.QueueName;
import ru.redsquid.examples.ms.order.service.OrderService;

@Component
@RequiredArgsConstructor
public class AccountingInvoicingReceiver {

    private final OrderService service;

    @RabbitListener(queues = QueueName.ACCOUNTING_INVOICING_EVENT)
    public void receive(AccountingInvoicingEvent event) {
        service.updateInvoicedState(event.getOrderId());
    }
}
