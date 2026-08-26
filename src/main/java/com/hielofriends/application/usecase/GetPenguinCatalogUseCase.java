package com.hielofriends.application.usecase;

import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import java.util.List;

// Caso de Uso para consultar el catálogo disponible
public class GetPenguinCatalogUseCase {
    private final PenguinPlushRepository repository;

    public GetPenguinCatalogUseCase(PenguinPlushRepository repository) {
        this.repository = repository;
    }

    public List<PenguinPlush> execute() {
        return repository.findAll();
    }
}