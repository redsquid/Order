package ru.redsquid.examples.ms.order.mq.accounting;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AccountingPaidEvent {

    private UUID orderId;
}
