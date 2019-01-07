package com.fastspring.api.pizza.controller;

import com.fastspring.api.pizza.model.CrustSize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CrustSizeController {

    @RequestMapping("/v1/crust_size")
    public @ResponseBody
    List<CrustSize> getAllPizzaCrustSizes() {
        return Arrays.asList(CrustSize.values());

    }

}
