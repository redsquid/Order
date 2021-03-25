package ru.redsquid.examples.ms.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.order.domain.Order;
import ru.redsquid.examples.ms.order.dto.OrderDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public Order find(UUID orderId) {
        System.out.println("FIND " + orderId);
        return null;
    }

    public UUID create(OrderDTO dto) {
        System.out.println("CREATE " + dto.toString());

        System.out.println("send to queue");
        rabbitTemplate.convertAndSend("orders", "Hello world");
        return null;
    }

    public void update(UUID orderId, OrderDTO dto) {
        System.out.println("UPDATE: " + orderId + " " + dto.toString());
    }

    public void delete(UUID orderId) {
        System.out.println("DELETE: " + orderId);
    }
}
