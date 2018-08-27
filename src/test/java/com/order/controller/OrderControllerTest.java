package com.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.domain.Item;
import com.order.domain.Order;
import com.order.domain.Tshirt;
import com.order.service.OrderService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.doubleThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private static ObjectMapper mapper;

    @BeforeClass
    public static void init(){
        mapper = new ObjectMapper();
    }

    @Test
    public void shouldReturn400WhenPOSTOrderWithNoItemsTest() throws Exception {
        //given
        given(orderService.placeOrder(any())).willReturn(this.getMockOrderResult());
        RequestBuilder postRequest = post("/v1/orders")
                .content(mapper.writeValueAsString(new Order()))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        //when
        this.mockMvc.perform(postRequest)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WhenPOSTOrderItemWithInvalidItemColorTest() throws Exception {

        final String requestBody = "{\"items\":[{\"quantity\":1,\"tshirt\":{\"color\":\"TEST\"}}]}";
        given(orderService.placeOrder(any())).willReturn(this.getMockOrderResult());
        RequestBuilder postRequest = post("/v1/orders")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        //when
        this.mockMvc.perform(postRequest)
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn200WhenPOSTSimpleOrderTest() throws Exception {

        final String requestBody = "{\"items\":[{\"quantity\":1,\"tshirt\":{\"color\":\"WHITE\"}}]}";
        given(orderService.placeOrder(any())).willReturn(this.getMockOrderResult());
        RequestBuilder postRequest = post("/v1/orders")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        //when
        this.mockMvc.perform(postRequest)
                .andExpect(status().isOk());
    }

    public Order getMockOrderResult(){
        Order order = new Order();
        order.setTotal(225000);
        return order;
    }
}

