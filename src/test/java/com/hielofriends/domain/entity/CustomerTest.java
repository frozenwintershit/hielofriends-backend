package com.hielofriends.domain.entity;

import com.hielofriends.domain.valueobject.Email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldCreateCustomerSuccessfully() {
        Email email = new Email("cliente@hielofriends.cl");
        Customer customer = new Customer("c-1", "Nicolás", email);

        assertEquals("c-1", customer.getId());
        assertEquals("Nicolás", customer.getName());
        assertEquals(email, customer.getEmail());
    }

    @Test
    void shouldThrowExceptionWhenFieldsAreInvalid() {
        Email email = new Email("test@mail.com");

        assertThrows(IllegalArgumentException.class, () -> new Customer(null, "Nicolás", email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("", "Nicolás", email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("   ", "Nicolás", email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("1", null, email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("1", "", email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("1", "   ", email));
        assertThrows(IllegalArgumentException.class, () -> new Customer("1", "Nicolás", null));
    }
}