package com.order.domain;

public class Tshirt {

    public enum Color { WHITE, YELLOW, PINK, GREEN, BLUE };
    public static final int PRICE = 60000;

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color tshirtColor) {
        this.color = tshirtColor;
    }
}
