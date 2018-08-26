package com.order.controller;

import com.order.domain.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/v1/orders")
    public ResponseEntity placeOrder(Order order) {
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
