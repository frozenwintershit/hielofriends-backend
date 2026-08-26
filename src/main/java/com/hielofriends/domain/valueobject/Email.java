package com.hielofriends.domain.valueobject;

import com.hielofriends.domain.exception.InvalidEmailException;

// Value Object inmutable usando record con validación defensiva
public record Email(String value) {
    public Email {
        if (value == null || value.isBlank() || !value.contains("@")) {
            throw new InvalidEmailException("Formato de correo electrónico inválido: " + value);
        }
        value = value.trim().toLowerCase();
    }
}