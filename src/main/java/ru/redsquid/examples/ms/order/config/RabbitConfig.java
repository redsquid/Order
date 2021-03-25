package ru.redsquid.examples.ms.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    private static final String TOPIC_EXCHANGE_NAME = "order-exchange";

    private static final String ORDER_QUEUE = "orders";

    private static final String CUSTOMER_QUEUE = "customers";

    @Bean
    Queue orderQueue() {
        return new Queue(ORDER_QUEUE, false);
    }

    @Bean
    Queue customerQueue() {
        return new Queue(CUSTOMER_QUEUE, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

//    @Bean
//    Binding bindingOrder(TopicExchange exchange) {
//        return BindingBuilder.bind(orderQueue()).to(exchange).with("MY_QUEUE123");
//    }
//
//    @Bean
//    Binding bindingCustomer(TopicExchange exchange) {
//        return BindingBuilder.bind(customerQueue()).to(exchange).with("MY_QUEUE123");
//    }

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter adapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(ORDER_QUEUE);
//        container.setMessageListener(adapter);
//        return container;
//    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveResponse");
//    }
}
