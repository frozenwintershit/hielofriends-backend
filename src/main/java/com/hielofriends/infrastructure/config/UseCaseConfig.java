package com.hielofriends.infrastructure.config;

import com.hielofriends.application.usecase.CreatePlushOrderUseCase;
import com.hielofriends.application.usecase.GetPenguinCatalogUseCase;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GetPenguinCatalogUseCase getPenguinCatalogUseCase(PenguinPlushRepository repository) {
        return new GetPenguinCatalogUseCase(repository);
    }

    @Bean
    public CreatePlushOrderUseCase createPlushOrderUseCase(PenguinPlushRepository repository) {
        return new CreatePlushOrderUseCase(repository);
    }
}