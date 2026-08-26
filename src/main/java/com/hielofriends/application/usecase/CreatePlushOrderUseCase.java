package com.hielofriends.application.usecase;

import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import com.hielofriends.domain.valueobject.Email;

// Caso de Uso cohesivo con inyección por constructor
public class CreatePlushOrderUseCase {
    private final PenguinPlushRepository repository;

    public CreatePlushOrderUseCase(PenguinPlushRepository repository) {
        this.repository = repository;
    }

    public void execute(String plushId, int quantity, Email customerEmail) {
        PenguinPlush plush = repository.findById(plushId)
            .orElseThrow(() -> new IllegalArgumentException("El peluche no existe en el catálogo."));

        plush.reduceStock(quantity);
        repository.save(plush);
    }
}