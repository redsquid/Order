package ru.redsquid.examples.ms.order.service;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.entity.Item;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.order.mapper.OrderMapper;
import ru.redsquid.examples.ms.order.repository.OrderRepository;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repo;

    private final RabbitTemplate rabbitTemplate;

    private final OrderMapper mapper;

    public Order find(UUID orderId) {
        System.out.println("FIND " + orderId);
        return null;
    }

    @Transactional
    public UUID create(OrderDTO dto) {
        System.out.println("CREATE " + dto.toString());


//        Order order = mapper.orderDTOToOrder(dto);
        Item item1 = new Item();
        item1.setItemId(UUID.randomUUID());

        Item item2 = new Item();
        item2.setItemId(UUID.randomUUID());


        Order order = new Order();
        order.setItems(Set.of(item1, item2));
        order.setState(Order.State.PENDING);


        System.out.println("Save to DB");
        Order saved = repo.save(order);


        System.out.println("Order id: " + saved.getId());
        System.out.println("send to queue");
        rabbitTemplate.convertAndSend("orders", "Hello world");
        return null;
    }

    public void update(UUID orderId, OrderDTO dto) {
        System.out.println("UPDATE: " + orderId + " " + dto.toString());
    }

    public void delete(UUID orderId) {
        System.out.println("DELETE: " + orderId);
    }
}
