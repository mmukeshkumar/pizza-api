package com.fastspring.api.pizza.model;

import com.fastspring.api.pizza.model.Cheese;
import com.fastspring.api.pizza.model.Pizza;
import com.fastspring.api.pizza.model.Sauce;
import com.fastspring.api.pizza.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;

public class NeapolitanPizza extends Pizza {

    private double price = 3.50;
    @Autowired
    ToppingService toppingService;

    public NeapolitanPizza() {
        super.addToBasePrice(price);
        super.setSauceType(Sauce.CLASSIC_RED);
        super.setCheeseType(Cheese.MOZZARELLA);
        super.addTopping(toppingService.getRomaTomatoTopping());
        super.addTopping(toppingService.getOliveOilTopping());
    }
}
