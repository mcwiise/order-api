package com.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TwoDifferentRuleTest {

    @InjectMocks
    private TwoDifferentRule twoDifferentRule;

    @Test
    public void shouldApply25PercentTest(){

        Integer result = this.twoDifferentRule.apply(100);

        assertEquals(95, result.intValue());
    }
}
