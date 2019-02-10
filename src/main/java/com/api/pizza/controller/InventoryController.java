package com.api.pizza.controller;

import com.api.pizza.model.Topping;
import com.api.pizza.model.Inventory;
import com.api.pizza.respository.InventoryRepository;
import com.api.pizza.respository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//TODO move all repository related calls to inside a Service so that it can be reused
public class InventoryController {

    private InventoryRepository inventoryRepository;
    private ToppingRepository toppingRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository, ToppingRepository toppingRepository) {
        this.inventoryRepository = inventoryRepository;
        this.toppingRepository = toppingRepository;
    }


    @PostMapping("/v1/inventory")
    public @ResponseBody
    Inventory addInventory(@RequestBody Inventory inventory) {
        Long toppingId = new Long(inventory.getToppingId());
        Optional<Topping> topping = toppingRepository.findById(toppingId);
        if (topping.isPresent()) {
            inventory.setTopping(topping.get());
            Inventory newInventory = inventoryRepository.save(inventory);
            return newInventory;
        } else {
            throw new RuntimeException("Topping does not exist");
        }

    }

    @PutMapping("/v1/inventory/{id}")
    public @ResponseBody
    Inventory updateInventory(@RequestBody Inventory inventory, @PathVariable Long id) {
        Optional<Inventory> inventoryToUpdate = getInventoryById(id);
        if (inventoryToUpdate.isPresent()) {
            Inventory inventory1 = inventoryToUpdate.get();
            inventory1.setQuantity(inventory.getQuantity());
            Inventory updatedInventory = inventoryRepository.save(inventory1);
            return updatedInventory;
        } else {
            throw new RuntimeException("Inventory does not exist");
        }

    }

    @RequestMapping("/v1/inventory")
    public @ResponseBody
    Iterable<Inventory> getAllInventory() {
        return inventoryRepository.findAll();

    }

    @RequestMapping("/v1/inventory/{id}")
    public @ResponseBody
    Optional<Inventory> getInventoryById(@PathVariable Long id) {
        return inventoryRepository.findById(id);

    }

    @DeleteMapping("/v1/inventory/{id}")
    public void deleteByToppingById(@PathVariable Long id) {
        inventoryRepository.deleteById(id);

    }

}
