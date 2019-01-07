package com.fastspring.api.pizza.respository;

import com.fastspring.api.pizza.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


}
