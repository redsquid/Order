package ru.redsquid.examples.ms.order.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.redsquid.examples.ms.order.domain.Order;
import ru.redsquid.examples.ms.order.domain.Person;
import ru.redsquid.examples.ms.order.dto.OrderDTO;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderMapperTest {

    private final OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @Test
    void dtoToOrderTest() {
        Set<UUID> items = Set.of(
                UUID.fromString("e43a669c-b126-4384-914f-acdbbff91171"),
                UUID.fromString("9371ef97-311a-4ce1-9995-4a8c221e0085")
        );
        OrderDTO dto = new OrderDTO("John", "Connor", "+79991231212", items, "address123");
        Order order = mapper.orderDTOToOrder(dto);
        assertEquals(dto.getFirstName(), order.getPerson().getFirstName());
        assertEquals(dto.getLastName(), order.getPerson().getLastName());
        assertEquals(dto.getPhone(), order.getPerson().getPhone());
        assertTrue(CollectionUtils.isEqualCollection(dto.getItems(), order.getItems()));
        assertEquals(dto.getDeliveryAddress(), order.getDeliveryAddress());
    }

    @Test
    void orderToDtoTest() {
        Set<UUID> items = Set.of(
                UUID.fromString("e43a669c-b126-4384-914f-acdbbff91171"),
                UUID.fromString("9371ef97-311a-4ce1-9995-4a8c221e0085")
        );

        Person person = new Person("+79991231212", "John", "Connor");
        Order order = new Order(items, person, "address123");
        OrderDTO dto = mapper.orderToOrderDTO(order);
        assertEquals(order.getPerson().getFirstName(), dto.getFirstName());
        assertEquals(order.getPerson().getLastName(), dto.getLastName());
        assertEquals(order.getPerson().getPhone(), dto.getPhone());
        assertTrue(CollectionUtils.isEqualCollection(order.getItems(), dto.getItems()));
        assertEquals(order.getDeliveryAddress(), dto.getDeliveryAddress());
    }
}
