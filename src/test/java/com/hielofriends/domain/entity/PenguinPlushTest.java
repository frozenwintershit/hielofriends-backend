package com.hielofriends.domain.entity;

import com.hielofriends.domain.exception.OutOfStockException;
import com.hielofriends.domain.valueobject.PlushPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PenguinPlushTest {

    @Test
    void shouldReduceStockWhenStockIsAvailable() {
        PenguinPlush plush = new PenguinPlush("1", "Pingüino Emperador", new PlushPrice(15990, "CLP"), 5);

        plush.reduceStock(2);

        assertEquals(3, plush.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenReducingMoreThanAvailableStock() {
        PenguinPlush plush = new PenguinPlush("2", "Pingüino Adelia", new PlushPrice(12990, "CLP"), 1);

        assertThrows(OutOfStockException.class, () -> plush.reduceStock(2));
    }

    @Test
    void shouldThrowExceptionWhenInitialDataIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> 
            new PenguinPlush("", "Pingüino Papúa", new PlushPrice(10000, "CLP"), 2));
        assertThrows(IllegalArgumentException.class, () -> 
            new PenguinPlush("3", "Pingüino Papúa", new PlushPrice(10000, "CLP"), -1));
    }
}