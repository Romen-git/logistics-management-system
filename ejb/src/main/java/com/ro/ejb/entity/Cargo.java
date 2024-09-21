package com.ro.ejb.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight;
    private String destination;
    private String status;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    public Cargo() {}

    public Cargo(String name, double weight, String destination, String status, Shipment shipment) {
        this.name = name;
        this.weight = weight;
        this.destination = destination;
        this.status = status;
        this.shipment = shipment;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
