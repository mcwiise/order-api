package com.order.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items;
    private double total;

    public Order(){
        this.items = new ArrayList<>();
    }

    public List<Item> getItems(){
        return items;
    }

    public void addItem(Item i){
        this.items.add(i);
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
