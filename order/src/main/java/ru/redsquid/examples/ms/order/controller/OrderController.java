package ru.redsquid.examples.ms.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.redsquid.examples.ms.order.client.Notification;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.service.OrderService;

import javax.annotation.security.RolesAllowed;
import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/order")
@Api(tags = "Order CRUD Service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @RolesAllowed({"ADMIN", "USER"})
    @PostMapping
    @ApiOperation(value = "Create order", response = UUID.class)
    public UUID create(@RequestBody OrderDTO dto) {
        return service.create(dto);
    }

    @RolesAllowed({"ADMIN"})
    @PostMapping("/order-{orderId}/notification")
    @ApiOperation(value = "Create order", response = UUID.class)
    public void sendNotification(@ApiParam("Order id (UUID)") @PathVariable UUID orderId, @RequestBody String message) {
        service.sendNotification(orderId, message);
    }
}
