package com.api.pizza.controller;

import com.api.pizza.model.Promotion;
import com.api.pizza.respository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//TODO move all repository related calls to inside a Service so that it can be reused
public class PromotionController {

    @Autowired
    PromotionRepository promotionRepository;

    @PostMapping("/v1/promotion")
    public @ResponseBody
    Promotion addPromotion(@RequestBody Promotion promotion) {
        Promotion newPromotion = promotionRepository.save(promotion);
        return newPromotion;

    }

    @RequestMapping("/v1/promotion")
    public @ResponseBody
    Iterable<Promotion> getAllPromotions() {
        return promotionRepository.findAll();

    }

    @RequestMapping("/v1/promotion/{id}")
    public @ResponseBody
    Optional<Promotion> getPromotionById(@PathVariable Long id) {
        return promotionRepository.findById(id);

    }


    @DeleteMapping("/v1/promotion/{id}")
    public void deleteByPromotionById(@PathVariable Long id) {
        promotionRepository.deleteById(id);

    }
}
