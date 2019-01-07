package com.fastspring.api.pizza.model;


public class RegularCheesePizza extends Pizza {

    private double price = 5.50;

    public RegularCheesePizza() {
        super.setName(Variety.REGULAR_CHEESE_PIZZA.name());
        super.addToBasePrice(price);
        super.setSauceType(Sauce.CLASSIC_RED);
        super.setCheeseType(Cheese.MOZZARELLA);
    }
}
