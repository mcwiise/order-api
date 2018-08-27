package com.order.service;

import org.springframework.stereotype.Component;

@Component
public class FourDifferentRule implements IRule {
    public static final int FOUR = 4;
    public static final Integer TWENTY = 20;

    @Override
    public Integer apply(Integer subTotal) {
        return subTotal - TWENTY*(subTotal/100);
    }
}
