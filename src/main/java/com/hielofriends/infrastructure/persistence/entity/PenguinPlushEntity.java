package com.hielofriends.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "penguin_plushes")
public class PenguinPlushEntity {

    @Id
    private String id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private int availableStock;

    public PenguinPlushEntity() {}

    public PenguinPlushEntity(String id, String model, double price, String currency, int availableStock) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.currency = currency;
        this.availableStock = availableStock;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public String getCurrency() { return currency; }
    public int getAvailableStock() { return availableStock; }
    public void setAvailableStock(int availableStock) { this.availableStock = availableStock; }
}