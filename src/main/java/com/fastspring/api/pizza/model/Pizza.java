package com.fastspring.api.pizza.model;

import java.util.List;
import java.util.ArrayList;

public abstract class Pizza {

    private String name;
    private Sauce sauce;
    private List<Topping> toppings = new ArrayList<>();
    private CrustSize crustSize;
    private double basePrice;
    private Cheese CheeseType;
    private boolean extraCheese;

// calculates the total prize based on all the customizations,
// the promotion discount percentage will applied on top of this total prize in the Order Controller
    public double getTotalPrize() {
        double totalPrice = basePrice + sauce.getPrice() + crustSize.getPrice() + CheeseType.getPrice();
        if (extraCheese) {
            totalPrice += 2.0;
        }
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }

        return totalPrice;
    }

    public Cheese getCheeseType() {
        return CheeseType;
    }

    public void setCheeseType(Cheese cheeseType) {
        CheeseType = cheeseType;
    }


    public Sauce getSauceType() {
        return sauce;
    }

    public void setSauceType(Sauce sauce) {
        this.sauce = sauce;
    }


    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void addToBasePrice(double basePrice) {
        this.basePrice += basePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public CrustSize getCrustSize() {
        return crustSize;
    }

    public void setCrustSize(CrustSize crustSize) {
        this.crustSize = crustSize;
    }

}
