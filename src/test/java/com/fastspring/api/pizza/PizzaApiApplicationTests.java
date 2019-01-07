package com.fastspring.api.pizza;

import com.fastspring.api.pizza.model.Inventory;
import com.fastspring.api.pizza.model.Topping;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PizzaApiApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testExistingToppingRecord() {
        Topping topping = this.restTemplate.getForObject("/v1/topping/1000", Topping.class);
        assertTrue(topping.getPrice() == 2.50);
        assertTrue(topping.getName().equals("SAN_MARZANO_TOMATO"));
    }


    @Test
    public void testExistingInventoryRecord() {
        Inventory inventory = this.restTemplate.getForObject("/v1/inventory/1000", Inventory.class);
        assertTrue(inventory.getInventoryId() == 1000);
        assertTrue(inventory.getQuantity() == 500);
    }

    @Test
    public void testInventoryVersionBumpAfterInventoryUpdate() {
        Inventory inventory = this.restTemplate.getForObject("/v1/inventory/1000", Inventory.class);
        assertTrue(inventory.getInventoryId() == 1000);
        assertTrue(inventory.getQuantity() == 500);

        long version = inventory.getVersion();
        // now perform an update

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        //update the quantity
        inventory.setQuantity(100);
        HttpEntity<Inventory> entity = new HttpEntity<>(inventory, headers);
        ResponseEntity<Inventory> response = restTemplate.exchange(
                "/v1/inventory/1000",
                HttpMethod.PUT, entity, Inventory.class);
        Inventory updateInventory = response.getBody();
        long updatedVersion = updateInventory.getVersion();
        assertTrue(response.getStatusCode().value() == 200);
        assertTrue(updateInventory.getQuantity() == 100);
        assertTrue(updatedVersion > version);

    }

    @Test
    public void testAddTopping() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Topping newTopping = new Topping("NEW_TOPPING", 0.50);
        HttpEntity<Topping> entity = new HttpEntity<>(newTopping, headers);
        ResponseEntity<Topping> response = restTemplate.exchange(
                "/v1/topping",
                HttpMethod.POST, entity, Topping.class);
        Topping addedTopping = response.getBody();
        assertTrue(response.getStatusCode().value() == 200);
        assertTrue(addedTopping.getPrice() == 0.50);
    }

}