package com.hielofriends.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PenguinPlushTest {

    @Test
    void shouldDecreaseStockWhenPurchasedSuccessfully() {
        PenguinPlush plush = new PenguinPlush("1", "Pingüino Emperador", 5);

        plush.purchase();

        assertEquals(4, plush.getAvailableStock());
    }

    @Test
    void shouldThrowExceptionWhenPurchasingOutOfStock() {
        PenguinPlush plush = new PenguinPlush("2", "Pingüino Adelia", 1);

        plush.purchase(); // Queda en 0

        assertThrows(OutOfStockException.class, plush::purchase);
    }

    @Test
    void shouldThrowExceptionWhenInitialStockIsZeroOrNegative() {
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("3", "Pingüino Papúa", 0));
        assertThrows(IllegalArgumentException.class, () -> new PenguinPlush("4", "Pingüino Papúa", -2));
    }
}
