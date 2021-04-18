package ru.redsquid.examples.ms.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Item {

    @Id
    private UUID id;

    private UUID orderId;

    private Long itemId;
}
