package com.fastspring.api.pizza.controller;

import com.fastspring.api.pizza.model.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fastspring.api.pizza.respository.ToppingRepository;

import java.util.*;

@RestController
public class ToppingController {

    private ToppingRepository toppingRepository;

    @Autowired
    public ToppingController(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    @PostMapping("/v1/topping")
    public @ResponseBody
    Topping addTopping(@RequestBody Topping topping) {
        Topping newTopping = toppingRepository.save(topping);
        return newTopping;

    }

    @RequestMapping("/v1/topping")
    public @ResponseBody
    Map<String, List<Topping>> getAllToppings() {
        Map<String, List<Topping>> result = new HashMap();
        List<Topping> toppings = new ArrayList();
        toppingRepository.findAll().forEach((Topping item) -> toppings.add(item));
        result.put("toppings", toppings);
        return result;
    }

    @RequestMapping("/v1/topping/{id}")
    public @ResponseBody
    Optional<Topping> getToppingById(@PathVariable Long id) {
        return toppingRepository.findById(id);

    }

    @PutMapping("/v1/topping/{id}")
    public @ResponseBody
    Topping updateTopping(@RequestBody Topping topping, @PathVariable Long id) {
        Optional<Topping> toppingById = getToppingById(id);
        if (toppingById.isPresent()) {
            Topping toppingToUpdate = toppingById.get();
            toppingToUpdate.setPrice(topping.getPrice());
            Topping updatedTopping = toppingRepository.save(toppingToUpdate);
            return updatedTopping;
        } else {
            throw new RuntimeException("Topping does not exist");
        }

    }


    @DeleteMapping("/v1/topping/{id}")
    public void deleteByToppingById(@PathVariable Long id) {
        toppingRepository.deleteById(id);

    }
}
