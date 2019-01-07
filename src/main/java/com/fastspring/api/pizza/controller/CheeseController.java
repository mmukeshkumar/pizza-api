package com.fastspring.api.pizza.controller;

import com.fastspring.api.pizza.model.Cheese;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CheeseController {


    @RequestMapping("/v1/cheese")
    public @ResponseBody
    List<Cheese> getAllPizzaCheeses() {
        return Arrays.asList(Cheese.values());

    }


}
