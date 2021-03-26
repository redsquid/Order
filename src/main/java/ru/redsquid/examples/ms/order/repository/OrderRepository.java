package ru.redsquid.examples.ms.order.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import ru.redsquid.examples.ms.order.entity.Order;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
