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

import static org.junit.Assert.assertNotNull;
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
        given(order.getItems()).willReturn(this.getMock5ItemList());

        //when
        Order result = this.orderService.placeOrder(order);
        //then
        assertNotNull(result);
    }

    @Test
    public void shouldPlaceOrderWhen4DifferentTshirtsTest(){
        //given
        given(rulesEngine.applyRules(any(), anyMap())).willReturn(this.getMockOrderResult());
        given(order.getItems()).willReturn(this.getMock4ItemList());
        //when
        Order result = this.orderService.placeOrder(order);

        //then
        assertNotNull(result);
    }

    private List<Item> getMock5ItemList() {
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

    private List<Item> getMock4ItemList() {
        Tshirt twhite = new Tshirt(Tshirt.Color.WHITE);
        Tshirt tblue = new Tshirt(Tshirt.Color.BLUE);
        Tshirt tgreen = new Tshirt(Tshirt.Color.GREEN);
        Tshirt tyellow = new Tshirt(Tshirt.Color.YELLOW);

        return Arrays.asList(new Item(1, twhite),
                new Item(1, tblue),
                new Item(1, tgreen),
                new Item(1, tyellow));
    }

    private Order getMockOrderResult(){
        Order order = new Order();
        order.setTotal(10);
        return order;
    }
}
