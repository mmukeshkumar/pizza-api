package com.api.pizza.model;

import com.api.pizza.service.ToppingService;

public class MargaritaPizza extends NeapolitanPizza {


    public MargaritaPizza(ToppingService toppingService) {
        super(toppingService);
        setName(Variety.MARGARITA_PIZZA.name());
    }
}
