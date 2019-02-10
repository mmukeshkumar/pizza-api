package com.api.pizza.model;

public enum Sauce {

    CLASSIC_RED(2.50), PESTO(3.50);

    private final double price;

    private Sauce(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

}
