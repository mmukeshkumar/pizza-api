package com.api.pizza.model;


public class RegularCheesePizza extends Pizza {

    private double price = 5.50;

    public RegularCheesePizza() {
        setName(Variety.REGULAR_CHEESE_PIZZA.name());
        addToBasePrice(price);
        setSauceType(Sauce.CLASSIC_RED);
        setCheeseType(Cheese.MOZZARELLA);
    }
}
