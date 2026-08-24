package com.hielofriends.domain;

public class PenguinPlush {
    // Atributos privados para proteger la información (Encapsulamiento)
    private final String id;
    private final String model;
    private final int initialStock;
    private int availableStock;

    // Constructor: Define los datos iniciales al registrar un nuevo modelo de pingüino
    public PenguinPlush(String id, String model, int initialStock) {
        if (initialStock <= 0) {
            throw new IllegalArgumentException("Initial stock must be greater than zero");
        }
        this.id = id;
        this.model = model;
        this.initialStock = initialStock;
        this.availableStock = initialStock; // Al inicio, todo el stock está disponible
    }

    // Regla de Negocio: Comprar/reservar una unidad de peluche
    public void purchase() {
        if (this.availableStock <= 0) {
            // Si no hay stock disponible, lanzamos la excepción de dominio
            throw new OutOfStockException("No stock available for penguin model: " + model);
        }
        this.availableStock--; // Disminuye en 1 la cantidad de peluches disponibles
    }

    // Métodos Getter: Permiten consultar la información sin modificarla directamente
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}