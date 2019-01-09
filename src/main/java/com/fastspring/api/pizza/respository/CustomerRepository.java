package com.fastspring.api.pizza.respository;

import com.fastspring.api.pizza.model.Customer;
import com.fastspring.api.pizza.model.Promotion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {


    @Query("SELECT customer FROM Customer customer WHERE customer.firstName=(:pFirstName) and customer.lastName = (:pLastName)")
    List<Customer> findByFirstNameAndLastName(@Param("pFirstName") String firstName, @Param("pLastName") String lastName);


}
