package com.order.domain;

import javax.validation.constraints.Min;

public class Item {

    @Min(value = 1)
    private Integer quantity;
    private Tshirt tshirt;

    public Item(){}

    public Item(Integer quantity, Tshirt tshirt){
        this.setQuantity(quantity);
        this.setTshirt(tshirt);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Tshirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(Tshirt tshirt) {
        this.tshirt = tshirt;
    }

    @Override
    public String toString() {
        return quantity + " - " + tshirt.getColor().name();
    }
}
