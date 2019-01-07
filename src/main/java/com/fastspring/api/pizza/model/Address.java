package com.fastspring.api.pizza.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    public Address() {}


    public Address(String streetAddress, String city,
                   String state, String zip) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zip;
    }


    @Override
    public String toString() {
        return "Address{" +
                ", addressId=" + addressId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
