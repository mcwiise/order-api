package com.order.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items;
    private double amount;
    private double discount;

    public Order(){
        this.items = new ArrayList<>();
    }

    public List<Item> getItems(){
        return items;
    }

    public void addItem(Item i){
        this.items.add(i);
    }

    public int getTotal() {
        return 0;
    }
}
