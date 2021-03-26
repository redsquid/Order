package ru.redsquid.examples.ms.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.order.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper {

//    @Mapping(target = "phone", source = "order.person.phone")
//    @Mapping(target = "firstName", source = "order.person.firstName")
//    @Mapping(target = "lastName", source = "order.person.lastName")
//    OrderDTO orderToOrderDTO(Order order);
//
//
//    @Mapping(target = "person.phone", source = "dto.phone")
//    @Mapping(target = "person.firstName", source = "dto.firstName")
//    @Mapping(target = "person.lastName", source = "dto.lastName")
//    Order orderDTOToOrder(OrderDTO dto);
}
