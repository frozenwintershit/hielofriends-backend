package com.neonpulse.domain;

public class Event {
    // Atributos privados para proteger la información (Encapsulamiento)
    private final String id;
    private final String title;
    private final int capacity;
    private int availableTickets;

    // Constructor: Define los datos iniciales al crear un nuevo evento
    public Event(String id, String title, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.id = id;
        this.title = title;
        this.capacity = capacity;
        this.availableTickets = capacity; // Al inicio, todas las entradas están disponibles
    }

    // Regla de Negocio: Reservar/comprar un ticket
    public void reserveTicket() {
        if (this.availableTickets <= 0) {
            // Si no hay cupos, lanzamos nuestra propia excepción personalizada
            throw new OutOfStockException("No tickets available for event: " + title);
        }
        this.availableTickets--; // Disminuye en 1 la cantidad de entradas
    }

    // Métodos Getter: Permiten consultar la información sin modificarla directamente
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}