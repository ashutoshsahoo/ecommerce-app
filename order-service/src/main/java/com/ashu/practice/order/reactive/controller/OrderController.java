package com.ashu.practice.order.reactive.controller;

import com.ashu.practice.common.constants.OrderStatus;
import com.ashu.practice.order.domain.Order;
import com.ashu.practice.order.reactive.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Mono<Order> create(@RequestBody Order order) {
        log.info("Create order invoked with: {}", order);
        return orderService.createOrder(order)
                .flatMap(o -> {
                    if (OrderStatus.FAILURE.equals(o.getOrderStatus())) {
                        return Mono.error(new RuntimeException("Order processing failed, please try again later. " + o.getResponseMessage()));
                    } else {
                        return Mono.just(o);
                    }
                });
    }

    @GetMapping
    public Flux<Order> getAll() {
        log.info("Get all orders invoked.");
        return orderService.getOrders();
    }

}