package ru.redsquid.examples.ms.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.redsquid.examples.ms.order.dto.OrderDTO;
import ru.redsquid.examples.ms.order.mapper.OrderMapper;
import ru.redsquid.examples.ms.order.service.OrderService;

import java.util.UUID;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/order")
@Api(tags = "Order CRUD Service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    private final OrderMapper mapper;

    @GetMapping("/order-{orderId}")
    @ApiOperation(value = "Find order by orderId", response = OrderDTO.class)
    public @ResponseBody OrderDTO find(@ApiParam("Order id (UUID)") @PathVariable UUID orderId) {
        return null; //mapper.orderToOrderDTO(service.find(orderId));
    }

    @PostMapping
    @ApiOperation(value = "Create order", response = UUID.class)
    public UUID create(@RequestBody OrderDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/order-{orderId}")
    @ApiOperation(value = "Update order by orderId")
    public void update(@ApiParam("Order id (UUID)") @PathVariable UUID orderId, @RequestBody OrderDTO dto) {
//        service.update(orderId, dto);
    }

    @DeleteMapping("/order-{orderId}")
    @ApiOperation(value = "Delete order by orderId")
    public void delete(@ApiParam("Order id (UUID)") @PathVariable UUID orderId) {
//        service.delete(orderId);
    }
}
