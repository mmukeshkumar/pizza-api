package com.fastspring.api.pizza.service;

import com.fastspring.api.pizza.model.Topping;
import com.fastspring.api.pizza.respository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {
    @Autowired
    ToppingRepository toppingRepository;

    public Topping getToppingByName(String name) {
        return toppingRepository.findByName(name).get(0);
    }

    public Topping getRomaTomatoTopping() {
        return toppingRepository.findByName("ROMA_TOMATO").get(0);
    }

    public Topping getPepperoniTopping() {
        return toppingRepository.findByName("PEPPERONI").get(0);
    }


    public Topping getOliveOilTopping() {
        return toppingRepository.findByName("OLIVE_OIL").get(0);
    }
}
