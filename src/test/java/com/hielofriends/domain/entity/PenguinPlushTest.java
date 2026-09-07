package com.hielofriends.domain.entity;

import com.hielofriends.domain.exception.OutOfStockException;
import com.hielofriends.domain.valueobject.PlushPrice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PenguinPlushTest {

    @Test
    void shouldCreatePenguinPlushAndGettersWork() {
        PlushPrice price = new PlushPrice(15990.0, "CLP");
        PenguinPlush plush = new PenguinPlush("p-1", "Emperador", price, 10);

        assertEquals("p-1", plush.getId());
        assertEquals("Emperador", plush.getModel());
        assertEquals(price, plush.getPrice());
        assertEquals(10, plush.getAvailableStock());
    }

    @Test
    void shouldThrowWhenConstructorArgumentsAreInvalid() {
        PlushPrice price = new PlushPrice(15990.0, "CLP");

        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush(null, "Modelo", price, 5));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("", "Modelo", price, 5));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("   ", "Modelo", price, 5));

        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("id", null, price, 5));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("id", "", price, 5));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("id", "   ", price, 5));

        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("id", "Modelo", null, 5));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("id", "Modelo", price, -1));
    }

    @Test
    void shouldReduceStockCorrectly() {
        PlushPrice price = new PlushPrice(15990.0, "CLP");
        PenguinPlush plush = new PenguinPlush("p-1", "Emperador", price, 10);

        plush.reduceStock(3);
        assertEquals(7, plush.getAvailableStock());

        plush.reduceStock(7);
        assertEquals(0, plush.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenReducingInvalidStock() {
        PlushPrice price = new PlushPrice(15990.0, "CLP");
        PenguinPlush plush = new PenguinPlush("p-1", "Emperador", price, 5);

        assertThrows(IllegalArgumentException.class, () -> plush.reduceStock(0));
        assertThrows(IllegalArgumentException.class, () -> plush.reduceStock(-1));
        assertThrows(OutOfStockException.class, () -> plush.reduceStock(6));
    }
}