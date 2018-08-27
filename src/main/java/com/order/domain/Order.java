package com.order.domain;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Order {

    @Size(min=1, message = "The order must have one item at least")
    private List<Item> items;
    private double total;

    public Order(){
        items = new ArrayList<>();
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
