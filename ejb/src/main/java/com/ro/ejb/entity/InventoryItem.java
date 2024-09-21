package com.ro.ejb.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class InventoryItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public InventoryItem() {}

    public InventoryItem(String name, int quantity, Location location) {
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
