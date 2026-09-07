package com.hielofriends.application;

import com.hielofriends.application.usecase.GetPenguinCatalogUseCase;
import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import com.hielofriends.domain.valueobject.PlushPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetPenguinCatalogUseCaseTest {

    @Mock
    private PenguinPlushRepository repository;

    @InjectMocks
    private GetPenguinCatalogUseCase useCase;

    @Test
    void shouldReturnAllPenguins() {
        PenguinPlush plush = new PenguinPlush("p-1", "Emperador", new PlushPrice(100.0, "CLP"), 5);
        when(repository.findAll()).thenReturn(List.of(plush));

        List<PenguinPlush> result = useCase.execute();

        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }
}