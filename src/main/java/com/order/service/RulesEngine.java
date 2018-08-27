package com.order.service;

import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RulesEngine {

    private FiveDifferentRule fiveDifferentRule;

    @Autowired
    public RulesEngine(FiveDifferentRule fiveDifferentRule){
        this.fiveDifferentRule = fiveDifferentRule;
    }

    public Order applyRules(Order order, Map<Tshirt.Color,Integer> groups) {
        Integer subTotal = order.getItems()
                .stream()
                .mapToInt(item -> item.getQuantity()*Tshirt.PRICE)
                .sum();

        switch (groups.size()){
            case FiveDifferentRule.FIVE:
                order.setTotal(this.fiveDifferentRule.apply(subTotal));
                break;
            default:
                order.setTotal(subTotal);
                break;
        }

        return order;
    }
}