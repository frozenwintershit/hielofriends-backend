package com.hielofriends.domain.repository;

import com.hielofriends.domain.entity.PenguinPlush;
import java.util.List;
import java.util.Optional;

// Contrato puro en el Dominio (Cero frameworks externos)
public interface PenguinPlushRepository {
    void save(PenguinPlush plush);
    Optional<PenguinPlush> findById(String id);
    List<PenguinPlush> findAll();
}