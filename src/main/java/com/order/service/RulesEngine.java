package com.order.service;

import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class RulesEngine {

    private FiveDifferentRule fiveDifferentRule;
    private FourDifferntRule fourDifferntRule;
    private ThreeDifferntRule threeDifferntRule;
    private TwoDifferentRule twoDifferentRule;


    @Autowired
    public RulesEngine(FiveDifferentRule fiveDifferentRule, FourDifferntRule fourDifferntRule,
                       ThreeDifferntRule threeDifferntRule, TwoDifferentRule twoDifferentRule ){
        this.fiveDifferentRule = fiveDifferentRule;
        this.fourDifferntRule = fourDifferntRule;
        this.threeDifferntRule = threeDifferntRule;
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
            case FourDifferntRule.FOUR:
                order.setTotal(this.fourDifferntRule.apply(subTotal));
                break;
            case ThreeDifferntRule.THREE:
                order.setTotal(this.threeDifferntRule.apply(subTotal));
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