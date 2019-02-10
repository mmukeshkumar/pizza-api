package com.api.pizza.model;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;

    @Column(nullable = false)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "toppingId", nullable = false, updatable = false, unique = true)
    private Topping topping;

    @Transient
    private Long toppingId;

    @Version
    // for makings sure inventory table updates will work fine when multi user attempt to update at the same time
    // for every successful update which chnages the data, hibernate automatically bumps the version
    // and updates with the older version data will be rejected by returning a data stale exception
    private long version;

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }


    public Inventory() {
    }

    public Long getToppingId() {
        return toppingId;
    }

    public void setToppingId(Long toppingId) {
        this.toppingId = toppingId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


}
