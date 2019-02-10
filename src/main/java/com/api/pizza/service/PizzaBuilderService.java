package com.api.pizza.service;

import com.api.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaBuilderService {

    private Pizza pizza;
    private ToppingService toppingService;

    @Autowired
    public PizzaBuilderService(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    public PizzaBuilderService withPizzaVariety(Variety pizzaVariety) {

        switch (pizzaVariety) {
            case REGULAR_CHEESE_PIZZA:
                this.pizza = new RegularCheesePizza();
                break;

            case MARGARITA_PIZZA:
                this.pizza = new MargaritaPizza(toppingService);
                break;

            case PEPPERONI:
                this.pizza = new PepperoniPizza(toppingService);
                break;
            default:
                this.pizza = new RegularCheesePizza();

        }
        return this;
    }

    // customization of toppings
    public PizzaBuilderService withExtraTopping(List<Topping> toppings) {
        for (Topping topping : toppings) {
            pizza.addTopping(topping);
        }

        return this;
    }

    // customization of cheese
    public PizzaBuilderService withCheese(Cheese cheese) {
        //replace Base pizza variety  cheese with new customer choice here
        pizza.setCheeseType(cheese);
        return this;
    }


    public PizzaBuilderService withExtraCheese(boolean extraCheese) {
        pizza.setExtraCheese(extraCheese);
        return this;
    }

    // customization of pizza size
    public PizzaBuilderService withCrustSize(CrustSize crustSize) {
        pizza.setCrustSize(crustSize);
        return this;
    }

    public Pizza build() {
        if (pizza == null || pizza.getCrustSize() == null || pizza.getCheeseType() == null) {
            throw new IllegalStateException("Pizza variety, crust size and cheese type are required to be set before creating the Pizza");
        }
        return pizza;
    }


}
