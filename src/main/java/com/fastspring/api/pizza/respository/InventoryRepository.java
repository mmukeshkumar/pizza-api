package com.fastspring.api.pizza.respository;

import com.fastspring.api.pizza.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {


}
