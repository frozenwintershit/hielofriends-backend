package com.hielofriends.domain;

// Hereda de RuntimeException para representar un error de regla de negocio
public class OutOfStockException extends RuntimeException {
    
    // Constructor que recibe un mensaje explicando el error
    public OutOfStockException(String message) {
        super(message);
    }
}