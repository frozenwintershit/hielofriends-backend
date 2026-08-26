package com.hielofriends.domain.entity;

import com.hielofriends.domain.exception.OutOfStockException;
import com.hielofriends.domain.valueobject.PlushPrice;

// Entidad principal con encapsulamiento de reglas de negocio
public class PenguinPlush {
    private final String id;
    private final String model;
    private final PlushPrice price;
    private int availableStock;

    public PenguinPlush(String id, String model, PlushPrice price, int initialStock) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del peluche no puede estar vacío.");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("El modelo del peluche no puede estar vacío.");
        }
        if (price == null) {
            throw new IllegalArgumentException("El precio es obligatorio.");
        }
        if (initialStock < 0) {
            throw new IllegalArgumentException("El stock inicial no puede ser negativo.");
        }
        this.id = id;
        this.model = model;
        this.price = price;
        this.availableStock = initialStock;
    }

    // Regla de negocio explícita (DDD)
    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a descontar debe ser mayor a cero.");
        }
        if (this.availableStock < quantity) {
            throw new OutOfStockException("Stock insuficiente para el peluche: " + model);
        }
        this.availableStock -= quantity;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public PlushPrice getPrice() { return price; }
    public int getAvailableStock() { return availableStock; }
}