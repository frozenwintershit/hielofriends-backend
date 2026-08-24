package com.hielofriends.domain;

public class PlushOrderService {
    // Dependemos de la interfaz, NO de una implementación concreta (Inversión de Dependencias)
    private final MessageNotifier messageNotifier;

    // Inyección obligatoria por constructor (Arquitectura limpia / Sin frameworks externos)
    public PlushOrderService(MessageNotifier messageNotifier) {
        this.messageNotifier = messageNotifier;
    }

    public void processOrder(PenguinPlush plush, String customerEmail) {
        // 1. Ejecutamos la regla de negocio sobre el peluche (descuenta stock o lanza excepción)
        plush.purchase();

        // 2. Notificamos al cliente a través del contrato desacoplado
        messageNotifier.sendNotification(
            customerEmail, 
            "Order successfully placed for penguin plush: " + plush.getModel()
        );
    }
}