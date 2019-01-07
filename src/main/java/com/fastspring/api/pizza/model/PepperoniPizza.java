package com.fastspring.api.pizza.model;

import com.fastspring.api.pizza.service.ToppingService;

public class PepperoniPizza extends Pizza {

    private double price = 5.50;

    private ToppingService toppingService;

    public PepperoniPizza(ToppingService toppingService) {
        super.setName(Variety.PEPPERONI.name());
        super.addToBasePrice(price);
        super.setSauceType(Sauce.CLASSIC_RED);
        super.setCheeseType(Cheese.MOZZARELLA);
        this.toppingService = toppingService;
        super.addTopping(toppingService.getPepperoniTopping());

    }
}