package com.fastspring.api.pizza.model;

import com.fastspring.api.pizza.service.ToppingService;

public class PepperoniPizza extends Pizza {

    private double price = 5.50;


    public PepperoniPizza(ToppingService toppingService) {
        setName(Variety.PEPPERONI.name());
        addToBasePrice(price);
        setSauceType(Sauce.CLASSIC_RED);
        setCheeseType(Cheese.MOZZARELLA);
        addTopping(toppingService.getPepperoniTopping());

    }
}