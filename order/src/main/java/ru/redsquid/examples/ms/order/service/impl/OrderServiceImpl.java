package ru.redsquid.examples.ms.order.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.entity.Order;
import ru.redsquid.examples.ms.order.mapper.OrderMapper;
import ru.redsquid.examples.ms.order.mq.sender.Sender;
import ru.redsquid.examples.ms.order.repository.OrderRepository;
import ru.redsquid.examples.ms.order.service.OrderService;
import ru.redsquid.examples.ms.store.queue.message.AcceptationCommand;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class OrderServiceImpl implements OrderService {

    private final OrderMapper mapper;

    private final OrderRepository repo;

    private final Sender sender;

    public UUID create(OrderDTO dto) {
        Order order = mapper.orderDTOToOrder(dto);
        order.setState(Order.State.PENDING);
        Order saved = repo.save(order);

        AcceptationCommand command = mapper.orderToCommand(order);
        System.out.println("service: send Acceptation command: " + command);
        sender.send(command, AcceptationCommand.KEY);

        return saved.getId();
    }

    @Transactional
    public void updateAcceptationState(UUID orderId, boolean accepted) {
        System.out.println("service: update Acceptation state" + orderId + " " + accepted);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.PENDING) {
            order.setState(accepted ? Order.State.CREATED : Order.State.DECLINE);
            repo.save(order);
        }
    }

    @Transactional
    public void updateInvoicedState(UUID orderId) {
        System.out.println("service: update Invoicing state" + orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.CREATED) {
            order.setState(Order.State.INVOICED);
            repo.save(order);
        }
    }

    @Transactional
    public void updatePaidState(UUID orderId) {
        System.out.println("service: update Paid state" + orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.INVOICED) {
            order.setState(Order.State.PAID);
            repo.save(order);
        }
    }

    @Transactional
    public void updateInProgressState(UUID orderId) {
        System.out.println("service: update InProgress state" + orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.PAID) {
            order.setState(Order.State.IN_PROGRESS);
            repo.save(order);
        }
    }

    @Transactional
    public void updateReadyState(UUID orderId) {
        System.out.println("service: update Ready state" + orderId);
        Order order = repo.findById(orderId).orElseThrow();
        if (order.getState() == Order.State.IN_PROGRESS) {
            order.setState(Order.State.READY);
            repo.save(order);
        }
    }
}
