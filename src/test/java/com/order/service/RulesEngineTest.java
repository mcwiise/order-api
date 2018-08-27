package com.order.service;

import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Or;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
public class RulesEngineTest {

    @Mock
    private FiveDifferentRule fiveDifferentRule;

    @Mock
    private FourDifferntRule fourDifferntRule;


    @InjectMocks
    private RulesEngine rulesEngine;

    @Test
    public void shouldApply25When5DifferentGroupsTest(){
        given(fiveDifferentRule.apply(any())).willReturn(225000);
        Order order = new Order();
        //when
        Order result = this.rulesEngine.applyRules(order, this.get5GroupsMap());

        //then
        assertEquals(225000, result.getTotal().intValue());
    }

    public Map<Tshirt.Color, Integer> get5GroupsMap(){
        Map<Tshirt.Color, Integer> groups = new HashMap<>();
        groups.put(Tshirt.Color.BLUE, 1);
        groups.put(Tshirt.Color.YELLOW, 1);
        groups.put(Tshirt.Color.GREEN, 1);
        groups.put(Tshirt.Color.PINK, 1);
        groups.put(Tshirt.Color.WHITE, 1);
        return groups;
    }
}
