package ru.redsquid.examples.ms.order.service;

import ru.redsquid.examples.ms.order.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {

    UUID create(OrderDTO dto);

    void updateAcceptationState(UUID orderId, boolean accepted);
}
