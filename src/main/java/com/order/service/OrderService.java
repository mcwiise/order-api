package com.order.service;

import com.order.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Order placeOrder(Order order){
        System.out.println(order.getItems());
        order.setTotal(255000d);
        return order;
    }
}
