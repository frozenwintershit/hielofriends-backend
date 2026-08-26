package com.hielofriends.infrastructure.persistence;

import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.repository.PenguinPlushRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Implementación concreta en memoria del contrato de repositorio
public class InMemoryPenguinRepository implements PenguinPlushRepository {
    private final Map<String, PenguinPlush> storage = new ConcurrentHashMap<>();

    @Override
    public void save(PenguinPlush plush) {
        storage.put(plush.getId(), plush);
    }

    @Override
    public Optional<PenguinPlush> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<PenguinPlush> findAll() {
        return new ArrayList<>(storage.values());
    }
}