package com.order.service;

import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RulesEngine {

    private FiveDifferentRule fiveDifferentRule;
    private FourDifferentRule fourDifferentRule;
    private ThreeDifferentRule threeDifferentRule;
    private TwoDifferentRule twoDifferentRule;


    @Autowired
    public RulesEngine(FiveDifferentRule fiveDifferentRule, FourDifferentRule fourDifferentRule,
                       ThreeDifferentRule threeDifferentRule, TwoDifferentRule twoDifferentRule ){
        this.fiveDifferentRule = fiveDifferentRule;
        this.fourDifferentRule = fourDifferentRule;
        this.threeDifferentRule = threeDifferentRule;
        this.twoDifferentRule = twoDifferentRule;
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
            case FourDifferentRule.FOUR:
                order.setTotal(this.fourDifferentRule.apply(subTotal));
                break;
            case ThreeDifferentRule.THREE:
                order.setTotal(this.threeDifferentRule.apply(subTotal));
                break;
            case TwoDifferentRule.TWO:
                order.setTotal(this.twoDifferentRule.apply(subTotal));
                break;
            default:
                order.setTotal(subTotal);
                break;
        }

        return order;
    }
}