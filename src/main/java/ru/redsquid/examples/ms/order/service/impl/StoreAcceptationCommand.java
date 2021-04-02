package ru.redsquid.examples.ms.order.service.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
public class StoreAcceptationCommand {

    private UUID orderId;

    private Set<UUID> items;
}
