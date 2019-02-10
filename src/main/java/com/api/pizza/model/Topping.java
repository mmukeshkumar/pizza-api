package com.api.pizza.model;

import javax.persistence.*;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toppingId;
    @Column(unique=true, nullable=false)
    private String name;
    @Column(nullable=false)
    private Double price;


    public Topping() {

    }

    public Topping(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }

    public Long getToppingId() {
        return toppingId;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "toppingId=" + toppingId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
