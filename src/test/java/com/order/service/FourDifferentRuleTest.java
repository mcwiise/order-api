package com.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class FourDifferentRuleTest {

    @InjectMocks
    private FourDifferentRule fourDifferentRule;

    @Test
    public void shouldApply20PercentTest(){

        Integer result = this.fourDifferentRule.apply(100);

        assertEquals(80, result.intValue());
    }
}
