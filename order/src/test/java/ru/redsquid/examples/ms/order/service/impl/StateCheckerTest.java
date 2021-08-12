package ru.redsquid.examples.ms.order.service.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.redsquid.examples.ms.order.entity.Order;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.redsquid.examples.ms.order.entity.Order.State.*;

class StateCheckerTest {

    private final StateChecker checker = new StateChecker();

    @ParameterizedTest
    @MethodSource("data")
    void test(Order order, Order.State state, boolean success) {
        assertEquals(success, checker.isAvailable(order, state));
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(order(PENDING), PENDING, false),
                Arguments.of(order(CREATED), CREATED, false),
                Arguments.of(order(READY), READY, false),
                Arguments.of(order(READY), PENDING, false),
                Arguments.of(order(PAID), INVOICED, false),
                Arguments.of(order(DECLINE), PENDING, false),
                Arguments.of(order(DECLINE), DECLINE, false),
                Arguments.of(order(DECLINE), CREATED, false),
                Arguments.of(order(DECLINE), INVOICED, false),
                Arguments.of(order(DECLINE), PAID, false),
                Arguments.of(order(DECLINE), IN_PROGRESS, false),
                Arguments.of(order(DECLINE), READY, false),

                Arguments.of(order(PENDING), CREATED, true),
                Arguments.of(order(PENDING), READY, true),
                Arguments.of(order(INVOICED), IN_PROGRESS, true),
                Arguments.of(order(PAID), IN_PROGRESS, true),
                Arguments.of(order(PAID), READY, true),

                Arguments.of(order(PENDING), DECLINE, true),
                Arguments.of(order(CREATED), DECLINE, true),
                Arguments.of(order(INVOICED), DECLINE, true),
                Arguments.of(order(PAID), DECLINE, true),
                Arguments.of(order(IN_PROGRESS), DECLINE, true),
                Arguments.of(order(READY), DECLINE, true)
        );
    }

    private static Order order(Order.State state) {
        Order order = new Order();
        order.setState(state);
        return order;
    }
}
