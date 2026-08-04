package com.neonpulse.domain;

public class BookingService {
    // Dependemos de la interfaz, NO de una implementación concreta (Inversión de Dependencias)
    private final MessageNotifier messageNotifier;

    // Inyección obligatoria por constructor (Sin @Autowired de Spring)
    public BookingService(MessageNotifier messageNotifier) {
        this.messageNotifier = messageNotifier;
    }

    public void bookTicket(Event event, String userEmail) {
        // 1. Ejecutamos la regla de negocio del evento
        event.reserveTicket();

        // 2. Notificamos al usuario a través de la interfaz
        messageNotifier.sendNotification(userEmail, "Ticket successfully reserved for: " + event.getTitle());
    }
}