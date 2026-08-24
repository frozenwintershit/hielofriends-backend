package com.hielofriends.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlushOrderServiceTest {

    @Mock
    private MessageNotifier messageNotifier;

    @InjectMocks
    private PlushOrderService orderService;

    @Test
    void shouldProcessOrderAndSendNotification() {
        PenguinPlush plush = new PenguinPlush("101", "Pingüino Penacho Amarillo", 3);
        String customerEmail = "cliente@hielofriends.com";

        orderService.processOrder(plush, customerEmail);

        // Verificamos que el stock disminuyó
        assert plush.getAvailableStock() == 2;

        // Verificamos con Mockito que se envió la notificación
        verify(messageNotifier, times(1)).sendNotification(
            eq(customerEmail),
            contains("Pingüino Penacho Amarillo")
        );
    }
}
