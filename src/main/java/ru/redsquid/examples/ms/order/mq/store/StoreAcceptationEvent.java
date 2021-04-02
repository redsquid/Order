package ru.redsquid.examples.ms.order.mq.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class StoreAcceptationEvent {

    private UUID orderId;

    private boolean accepted;
}
