package ru.redsquid.examples.ms.order.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.redsquid.examples.ms.accounting.queue.message.InvoicingEvent;
import ru.redsquid.examples.ms.accounting.queue.message.PaidEvent;
import ru.redsquid.examples.ms.order.mq.constants.Constants;
import ru.redsquid.examples.ms.store.queue.message.AcceptationEvent;
import ru.redsquid.examples.ms.store.queue.message.InProgressEvent;
import ru.redsquid.examples.ms.store.queue.message.ReadyEvent;

@Configuration
public class RabbitConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE);
    }

    @Bean
    Queue storeAcceptationEventQueue() {
        return new Queue(Constants.STORE_ACCEPTATION_EVENT_QUEUE, false);
    }

    @Bean
    Binding storeAcceptationEventQueueBinding(Queue storeAcceptationEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(storeAcceptationEventQueue).to(exchange).with(AcceptationEvent.KEY);
    }

    @Bean
    Queue accountingInvoicingEventQueue() {
        return new Queue(Constants.ACCOUNTING_INVOICING_EVENT_QUEUE, false);
    }

    @Bean
    Binding accountingInvoicingEventQueueBinding(Queue accountingInvoicingEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(accountingInvoicingEventQueue).to(exchange).with(InvoicingEvent.KEY);
    }

    @Bean
    Queue accountingPaidEventQueue() {
        return new Queue(Constants.ACCOUNTING_PAID_EVENT_QUEUE, false);
    }

    @Bean
    Binding accountingPaidEventBinding(Queue accountingPaidEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(accountingPaidEventQueue).to(exchange).with(PaidEvent.KEY);
    }

    @Bean
    Queue storeInProgressEventQueue() {
        return new Queue(Constants.STORE_IN_PROGRESS_EVENT_QUEUE, false);
    }

    @Bean
    Binding storeInProgressEventQueueBinding(Queue storeInProgressEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(storeInProgressEventQueue).to(exchange).with(InProgressEvent.KEY);
    }

    @Bean
    Queue storeReadyEventQueue() {
        return new Queue(Constants.STORE_READY_EVENT_QUEUE, false);
    }

    @Bean
    Binding storeReadyEventQueueBinding(Queue storeReadyEventQueue, DirectExchange exchange) {
        return BindingBuilder.bind(storeReadyEventQueue).to(exchange).with(ReadyEvent.KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
