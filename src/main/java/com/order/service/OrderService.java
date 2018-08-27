package com.order.service;

import com.order.domain.Item;
import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private RulesEngine rulesEngine;

    @Autowired
    public OrderService(RulesEngine rulesEngine){
        this.rulesEngine = rulesEngine;
    }

    public Order placeOrder(Order order){
        Map<Tshirt.Color, Integer> groups =
                order.getItems()
                        .stream()
                        .collect(Collectors.groupingBy(item -> item.getTshirt().getColor(), Collectors.summingInt(Item::getQuantity)));

        Order result = this.rulesEngine.applyRules(order, groups);

        return result;
    }
}
