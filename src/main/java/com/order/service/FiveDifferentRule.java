package com.order.service;
import org.springframework.stereotype.Component;

@Component
public class FiveDifferentRule implements IRule {

    public static final Integer TWENTY_FIVE = 25;
    public static final int FIVE = 5;

    @Override
    public Integer apply(Integer subTotal) {
        return subTotal - TWENTY_FIVE*(subTotal/100);
    }
}
