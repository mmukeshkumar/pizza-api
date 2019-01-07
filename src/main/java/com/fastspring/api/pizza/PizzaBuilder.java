package com.fastspring.api.pizza;

import com.fastspring.api.pizza.model.*;
import com.fastspring.api.pizza.service.ToppingService;

import java.util.List;

public class PizzaBuilder {

    private Pizza pizza;
    private ToppingService toppingService;


    public PizzaBuilder(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    public PizzaBuilder withPizzaVariety(Variety pizzaVariety) {

        switch (pizzaVariety) {
            case REGULAR_CHEESE_PIZZA:
                this.pizza = new RegularCheesePizza();
                break;

            case MARGARITA_PIZZA:
                this.pizza = new MargaritaPizza();
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
    public PizzaBuilder withExtraTopping(List<Topping> toppings) {
        for(Topping topping: toppings){
            pizza.addTopping(topping);
        }

        return this;
    }

    // customization of cheese
    public PizzaBuilder withCheese(Cheese cheese) {
        //replace Base pizza variety  cheese with new customer choice here
        pizza.setCheeseType(cheese);
        return this;
    }


    public PizzaBuilder withExtraCheese(boolean extraCheese) {
        pizza.setExtraCheese(extraCheese);
        return this;
    }

    // customization of pizza size
    public PizzaBuilder withCrustSize(CrustSize crustSize) {
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