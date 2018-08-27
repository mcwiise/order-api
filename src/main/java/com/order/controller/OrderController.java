package com.order.controller;

import com.order.domain.Order;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
       this.orderService = orderService;
    }

    @PostMapping("/v1/orders")
    public ResponseEntity createOrder(@Valid @RequestBody Order order) {

        Order result = this.orderService.placeOrder(order);

        return ResponseEntity.ok(result);
    }
}
