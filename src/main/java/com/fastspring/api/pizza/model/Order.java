package com.fastspring.api.pizza.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")// Database won't allow to create table with name: order since its a reserved word
public class Order {

    private double totalPrice;
    @Enumerated
    private Variety variety;
    private boolean extraCheese;
    @Enumerated
    private CrustSize crustSize;

    @Enumerated
    private Cheese cheese;

    private String extraToppings;

    private String promotionCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @ManyToOne()
    @JoinColumn(name = "customerId", nullable = false, updatable = false, unique = true)
    private Customer customer;


    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }
    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public String getExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(String extraToppings) {
        this.extraToppings = extraToppings;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public CrustSize getCrustSize() {
        return crustSize;
    }

    public void setCrustSize(CrustSize crustSize) {
        this.crustSize = crustSize;
    }


    public Order() {
    }

    public Order(double totalPrice, Date orderDate, Customer customer, Variety variety, CrustSize crustSize, boolean extraCheese, Cheese cheese, String extraToppings, String promotionCode) {
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.customer = customer;
        this.variety = variety;
        this.crustSize = crustSize;
        this.extraCheese = extraCheese;
        this.cheese = cheese;
        this.promotionCode = promotionCode;
        this.extraToppings = extraToppings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "totalPrice=" + totalPrice +
                ", orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                '}';
    }
}
