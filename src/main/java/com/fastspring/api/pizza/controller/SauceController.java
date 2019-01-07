package com.fastspring.api.pizza.controller;

import com.fastspring.api.pizza.model.Sauce;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SauceController {


    @RequestMapping("/v1/sauce")
    public @ResponseBody
    List<Sauce> getAllPizzaSauces() {
        return Arrays.asList(Sauce.values());

    }


}
