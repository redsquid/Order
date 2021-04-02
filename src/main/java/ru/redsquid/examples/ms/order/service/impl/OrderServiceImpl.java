package ru.redsquid.examples.ms.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.order.mapper.OrderMapper;
import ru.redsquid.examples.ms.order.repository.OrderRepository;
import ru.redsquid.examples.ms.order.service.OrderService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class OrderServiceImpl implements OrderService {

    private final OrderMapper mapper;

    private final OrderRepository repo;

    private final StoreAcceptationSender sender;

    public Order find(UUID orderId) {
        System.out.println("FIND " + orderId);
        return null;
    }

    public UUID create(OrderDTO dto) {
        System.out.println("CREATE " + dto.toString());

        Order order = mapper.orderDTOToOrder(dto);
        order.setState(Order.State.PENDING);
        Order saved = repo.save(order);
        sender.send("order: " + saved.getId() + " pending");
        return saved.getId();
    }

    public void update(UUID orderId, OrderDTO dto) {
        System.out.println("UPDATE: " + orderId + " " + dto.toString());
    }

    public void delete(UUID orderId) {
        System.out.println("DELETE: " + orderId);
    }
}
