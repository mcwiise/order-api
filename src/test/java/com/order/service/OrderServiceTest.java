package com.order.service;

import com.order.domain.Item;
import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Mock
    private Order order;

    @Mock
    private RulesEngine rulesEngine;

    @InjectMocks
    private OrderService orderService;


    @Test
    public void shouldPlaceOrderWhen5DifferentTshirtsTest(){
        //given
        given(rulesEngine.applyRules(any(), anyMap())).willReturn(this.getMockOrderResult());
        given(order.getItems()).willReturn(this.getMockItemList());
        //when
        Order result = this.orderService.placeOrder(order);

        //then
        assertEquals(Integer.valueOf(225000), result.getTotal());
    }

    private List<Item> getMockItemList() {
        Tshirt twhite = new Tshirt(Tshirt.Color.WHITE);
        Tshirt tblue = new Tshirt(Tshirt.Color.BLUE);
        Tshirt tgreen = new Tshirt(Tshirt.Color.GREEN);
        Tshirt tyellow = new Tshirt(Tshirt.Color.YELLOW);
        Tshirt tpink = new Tshirt(Tshirt.Color.PINK);

        return Arrays.asList(new Item(1, twhite),
                new Item(1, tblue),
                new Item(1, tgreen),
                new Item(1, tyellow),
                new Item(1, tpink));
    }

    private Order getMockOrderResult(){
        Order order = new Order();
        order.setTotal(225000);
        return order;
    }
}
