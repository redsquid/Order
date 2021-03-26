package ru.redsquid.examples.ms.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("orders")
public class Order {

    @Id
    private UUID id;

    @MappedCollection(idColumn = "order_id")
    private Set<Item> items;

    private UUID personId;

    private UUID deliveryAddressId;

    private State state;

    public enum State {
        PENDING,
        CREATED
    }
}
