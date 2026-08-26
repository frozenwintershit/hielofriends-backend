package com.hielofriends.application.usecase;

import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.exception.InvalidEmailException;
import com.hielofriends.domain.exception.OutOfStockException;
import com.hielofriends.domain.repository.PenguinPlushRepository;
import com.hielofriends.domain.valueobject.Email;
import com.hielofriends.domain.valueobject.PlushPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreatePlushOrderUseCaseTest {

    @Mock
    private PenguinPlushRepository repository;

    @InjectMocks
    private CreatePlushOrderUseCase useCase;

    @Test
    void shouldProcessOrderSuccessfullyWhenStockIsAvailable() {
        PenguinPlush plush = new PenguinPlush("p1", "Pingüino Emperador", new PlushPrice(15990, "CLP"), 5);
        when(repository.findById("p1")).thenReturn(Optional.of(plush));

        useCase.execute("p1", 2, new Email("cliente@hielofriends.com"));

        assertEquals(3, plush.getAvailableStock());
        verify(repository, times(1)).save(plush);
    }

    @Test
    void shouldThrowExceptionWhenStockIsInsufficient() {
        PenguinPlush plush = new PenguinPlush("p2", "Pingüino Adelia", new PlushPrice(12990, "CLP"), 1);
        when(repository.findById("p2")).thenReturn(Optional.of(plush));

        assertThrows(OutOfStockException.class, () ->
            useCase.execute("p2", 3, new Email("cliente@hielofriends.com"))
        );
    }

    @Test
    void shouldRejectInvalidEmailFormat() {
        assertThrows(InvalidEmailException.class, () -> new Email("correo-invalido.com"));
    }
}