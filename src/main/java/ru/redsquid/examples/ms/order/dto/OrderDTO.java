package ru.redsquid.examples.ms.order.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class OrderDTO {

    private final String firstName;

    private final String lastName;

    private final String phone;

    private final Set<UUID> items;

    private final String deliveryAddress;
}
