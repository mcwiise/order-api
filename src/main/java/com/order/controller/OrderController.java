package com.order.controller;

import com.order.domain.Order;
import com.order.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/v1")
@Api(value="Order Service", description="Handles information about orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
       this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity createOrder(@Valid @RequestBody Order order) {

        Order result = this.orderService.placeOrder(order);

        return ResponseEntity.ok(result);
    }
}
