package com.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class FiveDifferentRuleTest {

    @InjectMocks
    private FiveDifferentRule fiveDifferentRule;

    @Test
    public void shouldApply25PercentTest(){

        Integer result = this.fiveDifferentRule.apply(100);

        assertEquals(75, result.intValue());
    }
}
