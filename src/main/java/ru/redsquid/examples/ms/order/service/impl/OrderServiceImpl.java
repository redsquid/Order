package ru.redsquid.examples.ms.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    private final StoreAcceptationCommandSender sender;

    public Order find(UUID orderId) {
        System.out.println("FIND " + orderId);
        return null;
    }

    public UUID create(OrderDTO dto) {
        System.out.println("CREATE " + dto.toString());

        Order order = mapper.orderDTOToOrder(dto);
        order.setState(Order.State.PENDING);
        Order saved = repo.save(order);

        StoreAcceptationCommand command = mapper.orderToCommand(order);
        sender.send(command);

        return saved.getId();
    }

    @Transactional
    public void updateAcceptationState(UUID orderId, boolean accepted) {
        System.out.println("updateAcceptationState: " + orderId + " " + accepted);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.PENDING) {
            order.setState(accepted ? Order.State.CREATED : Order.State.DECLINE);
            repo.save(order);
        }
    }

    public void update(UUID orderId, OrderDTO dto) {
        System.out.println("UPDATE: " + orderId + " " + dto.toString());
    }

    public void delete(UUID orderId) {
        System.out.println("DELETE: " + orderId);
    }
}
