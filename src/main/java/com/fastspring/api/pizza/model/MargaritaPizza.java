package com.fastspring.api.pizza.model;

import com.fastspring.api.pizza.service.ToppingService;

public class MargaritaPizza extends NeapolitanPizza {


    public MargaritaPizza(ToppingService toppingService) {
        super(toppingService);
        setName(Variety.MARGARITA_PIZZA.name());
    }
}