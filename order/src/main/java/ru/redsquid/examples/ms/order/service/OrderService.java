package ru.redsquid.examples.ms.order.service;

import ru.redsquid.examples.ms.order.client.Notification;
import ru.redsquid.examples.ms.order.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {

    UUID create(OrderDTO dto);

    void updateAcceptationState(UUID orderId, boolean accepted);

    void updateInvoicedState(UUID orderId);

    void updatePaidState(UUID orderId);

    void updateInProgressState(UUID orderId);

    void updateReadyState(UUID orderId);

    void sendNotification(UUID orderId, String message);
}
