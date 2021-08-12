
package ru.redsquid.examples.ms.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("orders")
public class Order {

    @Id
    private UUID id;

    @MappedCollection(idColumn = "order_id")
    private Customer customer;

    @MappedCollection(idColumn = "order_id")
    private Set<Item> items;

    private State state;

    @NotNull
    private Boolean notification;

    public enum State {
        PENDING,
        DECLINE,
        CREATED,
        INVOICED,
        PAID,
        IN_PROGRESS,
        READY
    }
}
