package ru.redsquid.examples.ms.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.redsquid.examples.ms.order.entity.Item;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
}
