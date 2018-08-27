package com.order.service;

import org.springframework.stereotype.Component;

@Component
public class ThreeDifferntRule implements IRule {
    public static final int THREE = 3;
    public static final Integer TEN = 10;

    @Override
    public Integer apply(Integer subTotal) {
        return subTotal - TEN*(subTotal/100);
    }
}
