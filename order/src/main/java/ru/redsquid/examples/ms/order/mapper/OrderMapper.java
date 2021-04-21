package ru.redsquid.examples.ms.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.entity.Item;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.store.queue.message.AcceptationCommand;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "phone", source = "order.customer.phone")
    @Mapping(target = "name", source = "order.customer.name")
    @Mapping(target = "items", source = "order.items")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "customer.phone", source = "dto.phone")
    @Mapping(target = "customer.name", source = "dto.name")
    @Mapping(target = "items", source = "dto.items")
    Order orderDTOToOrder(OrderDTO dto);

    @Mapping(target = "itemId", source = "itemId")
    Item uuidToItem(Long itemId);

    default Long uuidToItem(Item item) {
        return item.getItemId();
    }

    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "items", source = "order.items")
    AcceptationCommand orderToCommand(Order order);
}
