package com.hielofriends.infrastructure.persistence.repository;

import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import com.hielofriends.domain.valueobject.PlushPrice;
import com.hielofriends.infrastructure.persistence.entity.PenguinPlushEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostgresPenguinRepository implements PenguinPlushRepository {

    private final PenguinJpaRepository jpaRepository;

    public PostgresPenguinRepository(PenguinJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(PenguinPlush plush) {
        PenguinPlushEntity entity = new PenguinPlushEntity(
            plush.getId(),
            plush.getModel(),
            plush.getPrice().amount(),
            plush.getPrice().currency(),
            plush.getAvailableStock()
        );
        jpaRepository.save(entity);
    }

    @Override
    public Optional<PenguinPlush> findById(String id) {
        return jpaRepository.findById(id).map(entity -> new PenguinPlush(
            entity.getId(),
            entity.getModel(),
            new PlushPrice(entity.getPrice(), entity.getCurrency()),
            entity.getAvailableStock()
        ));
    }

    @Override
    public List<PenguinPlush> findAll() {
        return jpaRepository.findAll().stream()
            .map(entity -> new PenguinPlush(
                entity.getId(),
                entity.getModel(),
                new PlushPrice(entity.getPrice(), entity.getCurrency()),
                entity.getAvailableStock()
            ))
            .toList();
    }
}