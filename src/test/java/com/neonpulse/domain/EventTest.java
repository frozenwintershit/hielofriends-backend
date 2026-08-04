package com.neonpulse.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void shouldDecreaseAvailableTicketsWhenReserved() {
        Event event = new Event("EVT-01", "Rock Concert", 100);

        event.reserveTicket();

        assertEquals(99, event.getAvailableTickets());
    }

    @Test
    void shouldThrowExceptionWhenNoTicketsAvailable() {
        Event event = new Event("EVT-02", "Indie Fest", 1);
        event.reserveTicket();

        OutOfStockException exception = assertThrows(
            OutOfStockException.class,
            () -> event.reserveTicket()
        );

        assertEquals("No tickets available for event: Indie Fest", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCapacityIsInvalid() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Event("EVT-03", "Invalid Event", 0)
        );
    }

    @Test
void shouldReturnCorrectEventDetails() {
    Event event = new Event("EVT-10", "Tech Conference", 50);

    assertEquals("EVT-10", event.getId());
    assertEquals("Tech Conference", event.getTitle());
    assertEquals(50, event.getCapacity());
    }
}
