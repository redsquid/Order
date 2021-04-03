package ru.redsquid.examples.ms.order.mq.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class StoreInProgressEvent {

    private UUID orderId;
}
