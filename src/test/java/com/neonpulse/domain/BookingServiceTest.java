package com.neonpulse.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private MessageNotifier messageNotifier;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void shouldBookTicketAndSendNotification() {
        Event event = new Event("EVT-10", "Tech Conference", 50);
        String userEmail = "user@example.com";

        bookingService.bookTicket(event, userEmail);

        verify(messageNotifier, times(1)).sendNotification(
            userEmail,
            "Ticket successfully reserved for: Tech Conference"
        );
    }
}
