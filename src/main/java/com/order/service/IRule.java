package com.order.service;

import com.order.domain.Order;

public interface IRule {
    public Integer apply(Integer subTotal);
}
