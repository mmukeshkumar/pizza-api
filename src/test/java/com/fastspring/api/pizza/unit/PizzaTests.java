package com.fastspring.api.pizza.unit;

import com.fastspring.api.pizza.service.PizzaBuilderService;
import com.fastspring.api.pizza.model.*;
import com.fastspring.api.pizza.service.ToppingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class PizzaTests {

    @MockBean
    private ToppingService toppingService;


    @Test
    public void testRegularCheesePizzaTotalPrice() {
        PizzaBuilderService pizzaBuilderService = new PizzaBuilderService(toppingService);
        // test large size
        Pizza regularCheesePizza = pizzaBuilderService.withPizzaVariety(Variety.REGULAR_CHEESE_PIZZA).withCrustSize(CrustSize.LARGE).build();
        double price = regularCheesePizza.getTotalPrize();
        assertTrue(price == 18.00);
        assertTrue(regularCheesePizza.getName().equals("REGULAR_CHEESE_PIZZA"));

        // test medium size
        regularCheesePizza = pizzaBuilderService.withPizzaVariety(Variety.REGULAR_CHEESE_PIZZA).withCrustSize(CrustSize.MEDIUM).build();
        price = regularCheesePizza.getTotalPrize();
        assertTrue(price == 16.00);
        assertTrue(regularCheesePizza.getName().equals("REGULAR_CHEESE_PIZZA"));


        // test small size
        regularCheesePizza = pizzaBuilderService.withPizzaVariety(Variety.REGULAR_CHEESE_PIZZA).withCrustSize(CrustSize.SMALL).build();
        price = regularCheesePizza.getTotalPrize();
        assertTrue(price == 14.00);
        assertTrue(regularCheesePizza.getName().equals("REGULAR_CHEESE_PIZZA"));

        // test small size with extra cheese
        regularCheesePizza = pizzaBuilderService.withPizzaVariety(Variety.REGULAR_CHEESE_PIZZA).withCrustSize(CrustSize.SMALL).withExtraCheese(true).build();
        price = regularCheesePizza.getTotalPrize();
        assertTrue(price == 16.00);
        assertTrue(regularCheesePizza.getName().equals("REGULAR_CHEESE_PIZZA"));

    }


}
