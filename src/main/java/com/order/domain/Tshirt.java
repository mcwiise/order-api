package com.order.domain;

public class Tshirt {

    public enum Color { WHITE, YELLOW, PINK, GREEN, BLUE };

    public static final int PRICE = 60000;

    private Color color;

    public Tshirt(){}

    public Tshirt(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.name() + "-";
    }
}