package com.api.pizza.model;

public enum Cheese {

    AMERICAN(1.00), PROVOLONE(2.00), MOZZARELLA(3.50), CHEDDAR(3.50);

    private final double price;

    private Cheese(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

}
