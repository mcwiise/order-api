package com.order.controller;

import com.order.domain.Item;
import com.order.domain.Order;
import com.order.domain.Tshirt;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
public class OrderControllerTest {

    private OrderController orderController;

    @Before
    public void init(){
        this.orderController = new OrderController();
    }

    @Test
    public void shouldReturn200WhenPOSTSimpleOrder(){
        //given
        Order mockOrder = this.getMockOrder();

        //when
        ResponseEntity response = this.orderController.placeOrder(mockOrder);

        //then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private Order getMockOrder(){
        Order order = new Order();
        Item item = new Item();
        Tshirt tshirt = new Tshirt();
        tshirt.setColor(Tshirt.Color.WHITE);
        item.setQuantity(1);
        item.setTshirt(tshirt);
        order.addItem(item);
        return order;
    }
}

