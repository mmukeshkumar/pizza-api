package com.api.pizza.model;

import com.api.pizza.service.ToppingService;

public class NeapolitanPizza extends Pizza {

    private double price = 5.50;


    public NeapolitanPizza(ToppingService toppingService) {
        addToBasePrice(price);
        setSauceType(Sauce.CLASSIC_RED);
        setCheeseType(Cheese.MOZZARELLA);
        addTopping(toppingService.getRomaTomatoTopping());
        addTopping(toppingService.getOliveOilTopping());
    }
}
