package ru.redsquid.examples.ms.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Order {

    @Setter
    private UUID id;

    private final Set<UUID> items;

    private final Person person;

    private final String deliveryAddress;
}
