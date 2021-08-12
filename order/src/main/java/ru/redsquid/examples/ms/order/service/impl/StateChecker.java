package ru.redsquid.examples.ms.order.service.impl;

import org.springframework.stereotype.Component;
import ru.redsquid.examples.ms.order.entity.Order;

import java.util.List;

import static ru.redsquid.examples.ms.order.entity.Order.State.*;

@Component
class StateChecker {

    private static final List<Order.State> ORDER = List.of(PENDING, CREATED, INVOICED, PAID, IN_PROGRESS, READY);

    boolean isAvailable(Order order, Order.State state) {
        if (order.getState() == DECLINE) {
            return false;
        } else if (state == DECLINE) {
            return true;
        }
        return ORDER.indexOf(order.getState()) < ORDER.indexOf(state);
    }
}
