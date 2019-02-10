package com.api.pizza.respository;

import com.api.pizza.model.Topping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends CrudRepository<Topping, Long> {


    @Query("SELECT topping FROM Topping topping WHERE topping.name=(:pName)")
    List<Topping> findByName(@Param("pName") String name);


}
