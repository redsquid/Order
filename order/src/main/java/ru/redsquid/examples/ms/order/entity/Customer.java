package ru.redsquid.examples.ms.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@Data
public class Customer {

    @Id
    private UUID orderId;

    private String phone;

    private String name;
}
