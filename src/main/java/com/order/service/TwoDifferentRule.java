package com.order.service;
import org.springframework.stereotype.Component;

@Component
public class TwoDifferentRule implements IRule {

    public static final Integer FIVE = 5;
    public static final int TWO = 2;

    @Override
    public Integer apply(Integer subTotal) {
        return subTotal - FIVE*(subTotal/100);
    }
}
