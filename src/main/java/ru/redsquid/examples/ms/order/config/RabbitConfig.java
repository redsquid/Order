package ru.redsquid.examples.ms.order.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ru.redsquid.examples.ms.order.constants.QueueName.*;


@Configuration
public class RabbitConfig {

    @Bean
    Queue storeAcceptationCommandsQueue() {
        return new Queue(STORE_ACCEPTATION_COMMAND, false);
    }

    @Bean
    Queue storeAcceptationEventQueue() {
        return new Queue(STORE_ACCEPTATION_EVENT, false);
    }

    @Bean
    Queue accountingInvoicingEventQueue() {
        return new Queue(ACCOUNTING_INVOICING_EVENT, false);
    }

    @Bean
    Queue accountingPaidEventQueue() {
        return new Queue(ACCOUNTING_PAID_EVENT, false);
    }

    @Bean
    Queue storeInProgressEventQueue() {
        return new Queue(STORE_IN_PROGRESS_EVENT, false);
    }

    @Bean
    Queue storeReadyEventQueue() {
        return new Queue(STORE_READY_EVENT, false);
    }

//    @Bean
//    Queue accountingInvoicedEventQueue() {
//        return new Queue(ACCOUNTING_INVOICED_EVENT, false);
//    }
//
//    @Bean
//    Queue accountingPaidEventQueue() {
//        return new Queue(ORDER_ACCOUNTING_PAID_EVENT, false);
//    }
//
//    @Bean
//    Queue storeInProgressEventQueue() {
//        return new Queue(STORE_IN_PROGRESS_EVENT, false);
//    }
//
//    @Bean
//    Queue storeReadyEventQueue() {
//        return new Queue(STORE_READY_EVENT, false);
//    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
