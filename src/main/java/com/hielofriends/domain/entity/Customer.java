package com.hielofriends.domain.entity;

import com.hielofriends.domain.valueobject.Email;

// Entidad con identidad única
public class Customer {
    private final String id;
    private String name;
    private Email email; // Protegido mediante Value Object

    public Customer(String id, String name, Email email) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID del cliente no puede estar vacío.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (email == null) {
            throw new IllegalArgumentException("El email es obligatorio.");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Email getEmail() { return email; }
}