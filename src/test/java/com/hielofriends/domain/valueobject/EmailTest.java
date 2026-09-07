package com.hielofriends.domain.valueobject;

import com.hielofriends.domain.exception.InvalidEmailException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldCreateValidEmail() {
        Email email = new Email("usuario@hielofriends.cl");
        assertEquals("usuario@hielofriends.cl", email.value());
    }

    @Test
    void shouldThrowWhenEmailIsInvalid() {
        assertThrows(InvalidEmailException.class, () -> new Email(null));
        assertThrows(InvalidEmailException.class, () -> new Email(""));
        assertThrows(InvalidEmailException.class, () -> new Email("   "));
        assertThrows(InvalidEmailException.class, () -> new Email("correo-sin-arroba.com"));
    }
}