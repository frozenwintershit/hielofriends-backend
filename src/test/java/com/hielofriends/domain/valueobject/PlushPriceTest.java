package com.hielofriends.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlushPriceTest {

    @Test
    void shouldCreateValidPlushPrice() {
        PlushPrice price = new PlushPrice(12990.0, "CLP");
        assertEquals(12990.0, price.amount());
        assertEquals("CLP", price.currency());
    }

    @Test
    void shouldThrowWhenPriceOrCurrencyAreInvalid() {
        assertThrows(IllegalArgumentException.class, () -> new PlushPrice(-1.0, "CLP"));
        assertThrows(IllegalArgumentException.class, () -> new PlushPrice(0.0, "CLP"));
        assertThrows(IllegalArgumentException.class, () -> new PlushPrice(100.0, null));
        assertThrows(IllegalArgumentException.class, () -> new PlushPrice(100.0, ""));
        assertThrows(IllegalArgumentException.class, () -> new PlushPrice(100.0, "   "));
    }
}