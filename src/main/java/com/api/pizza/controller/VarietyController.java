package com.api.pizza.controller;

import com.api.pizza.model.Variety;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class VarietyController {


    @RequestMapping("/v1/variety")
    public @ResponseBody
    List<Variety> getAllPizzaVarieties() {
        return Arrays.asList(Variety.values());

    }


}
