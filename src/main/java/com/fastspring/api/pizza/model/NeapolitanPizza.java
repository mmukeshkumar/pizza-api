package com.fastspring.api.pizza.model;

import com.fastspring.api.pizza.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;

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
