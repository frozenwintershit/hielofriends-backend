# NeonPulse Core - Módulo de Dominio y Pruebas Unitarias

Este proyecto contiene el núcleo de dominio (*Core Domain*) para la gestión y reserva de entradas de eventos, desarrollado con Java 21 puro y alineado a las mejores prácticas de Arquitectura Limpia (sin dependencias externas en el dominio).

---

## 🛠️ Tecnologías y Herramientas
* **Lenguaje:** Java 21
* **Gestor de Construcción:** Apache Maven
* **Framework de Pruebas:** JUnit 5 (Jupiter)
* **Framework de Mocks:** Mockito Core
* **Reporte de Cobertura:** JaCoCo Maven Plugin

---

## 🏗️ Arquitectura de Paquetes y Clases

### Código de Producción (`src/main/java/com/neonpulse/domain/`)
* **`Event.java`**: Entidad principal de dominio que gestiona la capacidad y reserva de tickets.
* **`OutOfStockException.java`**: Excepción de dominio para cuando no hay tickets disponibles.
* **`MessageNotifier.java`**: Interfaz/Contrato para el envío de notificaciones desacopladas.
* **`BookingService.java`**: Servicio de dominio que coordina la reserva de tickets y la activación de notificaciones.

### Código de Pruebas (`src/test/java/com/neonpulse/domain/`)
* **`EventTest.java`**: Pruebas unitarias para la entidad `Event`, verificando casos de éxito, agotamiento de stock y límites de capacidad.
* **`BookingServiceTest.java`**: Pruebas unitarias para `BookingService` utilizando **Mockito** para aislar y verificar las interacciones con `MessageNotifier`.

---

## 🚀 Comandos de Ejecución (Maven)

### Compilar el proyecto
```bash
mvn clean compile
```
### ejecutar la suite de pruebas
```bash
mvn clean test
```
