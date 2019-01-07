package com.fastspring.api.pizza.respository;

import com.fastspring.api.pizza.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
