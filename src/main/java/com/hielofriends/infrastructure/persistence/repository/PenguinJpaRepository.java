package com.hielofriends.infrastructure.persistence.repository;

import com.hielofriends.infrastructure.persistence.entity.PenguinPlushEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenguinJpaRepository extends JpaRepository<PenguinPlushEntity, String> {
}