package ru.redsquid.examples.ms.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.service.OrderService;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/order")
@Api(tags = "Order CRUD Service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    @ApiOperation(value = "Create order", response = UUID.class)
    public UUID create(@RequestBody OrderDTO dto) {
        return service.create(dto);
    }
}
