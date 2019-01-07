package com.fastspring.api.pizza.controller;

import com.fastspring.api.pizza.PizzaBuilder;
import com.fastspring.api.pizza.model.Customer;
import com.fastspring.api.pizza.model.Order;
import com.fastspring.api.pizza.model.Pizza;
import com.fastspring.api.pizza.model.Topping;
import com.fastspring.api.pizza.respository.CustomerRepository;
import com.fastspring.api.pizza.respository.OrderRepository;
import com.fastspring.api.pizza.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private OrderRepository orderRepository;
    private ToppingService toppingService;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, ToppingService toppingService, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.toppingService = toppingService;
        this.customerRepository = customerRepository;
    }


    @PostMapping("/v1/order")
    @Transactional
    public @ResponseBody
    Order addTopping(@RequestBody Order order) {
        Customer customer = order.getCustomer();
        customer = customerRepository.save(customer);
        PizzaBuilder pizzaBuilder = new PizzaBuilder(toppingService);
        List<Topping> toppings = new ArrayList();
        if (order.getExtraToppings() != null) {
            String[] extraToppings = order.getExtraToppings().split(",");
            for (String toppingName : extraToppings) {
                Topping topping1 = toppingService.getToppingByName(toppingName);
                toppings.add(topping1);
            }
        }

        Pizza pizza = pizzaBuilder.withPizzaVariety(order.getVariety()).withCrustSize(order.getCrustSize()).withExtraTopping(toppings).withCheese(order.getCheese()).withExtraCheese(order.isExtraCheese()).build();
        double totalPrize = pizza.getTotalPrize();

        // TODO apply promotion discount here by subtracting the percentage from the total order amount

        order.setTotalPrice(totalPrize);
        Order newOrder = orderRepository.save(order);
        // once order is saved successfully reduce the inventory
        //TODO
        return newOrder;

    }

    @RequestMapping("/v1/order")
    public @ResponseBody
    Iterable<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @RequestMapping("/v1/order/{id}")
    public @ResponseBody
    Optional<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id);

    }


    @DeleteMapping("/v1/order/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderRepository.deleteById(id);

    }
}
