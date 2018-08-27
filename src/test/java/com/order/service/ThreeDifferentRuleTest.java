package com.order.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ThreeDifferentRuleTest {

    @InjectMocks
    private ThreeDifferentRule threeDifferentRule;

    @Test
    public void shouldApply25PercentTest(){

        Integer result = this.threeDifferentRule.apply(100);

        assertEquals(90, result.intValue());
    }
}
