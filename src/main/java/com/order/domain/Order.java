package com.order.domain;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class Order {

    @Size(min=1, message = "The order must have one item at least")
    private List<Item> items;
    private Integer total;

    public Order(){
        items = new ArrayList<>();
    }

    public List<Item> getItems(){
        return items;
    }

    public void addItem(Item i){
        this.items.add(i);
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
