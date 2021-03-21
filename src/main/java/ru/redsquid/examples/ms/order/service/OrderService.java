package ru.redsquid.examples.ms.order.service;

import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.order.domain.Order;
import ru.redsquid.examples.ms.order.dto.OrderDTO;

import java.util.UUID;

@Service
public class OrderService {

    public Order find(UUID orderId) {
        return null;
    }

    public UUID create(OrderDTO dto) {
        return null;
    }

    public void update(UUID orderId, OrderDTO dto) {

    }

    public void delete(UUID orderId) {

    }
}
