package com.hielofriends.domain.valueobject;

// Value Object inmutable para representar el precio y moneda
public record PlushPrice(double amount, String currency) {
    public PlushPrice {
        if (amount <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("La moneda no puede estar vacía.");
        }
        currency = currency.trim().toUpperCase();
    }
}