package com.fastspring.api.pizza.model;

public enum CrustSize {

    SMALL(2.50), MEDIUM(4.50), LARGE(6.50);

    private final double price;

    private CrustSize(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

}
