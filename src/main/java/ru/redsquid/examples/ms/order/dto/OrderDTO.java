package ru.redsquid.examples.ms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@ToString
@Data
@NoArgsConstructor
public class OrderDTO {

    private String name;

    private String phone;

    private Set<UUID> items;
}
