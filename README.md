# Hielofriends Core - Módulo de Dominio y Pruebas Unitarias

Este proyecto contiene el núcleo de dominio (*Core Domain*) para la gestión de inventario, modelos y órdenes de compra de peluches de pingüinos de **Hielofriends**. Está desarrollado con **Java 21** y alineado estrictamente con las prácticas de Arquitectura Limpia (sin dependencias externas ni acoplamiento en el dominio).

---

## 🛠️ Tecnologías y Herramientas

- **Lenguaje:** Java 21
- **Gestor de Construcción:** Apache Maven
- **Framework de Pruebas:** JUnit 5 (Jupiter)
- **Framework de Mocks:** Mockito Core
- **Reporte de Cobertura:** JaCoCo Maven Plugin

---

## 🏛️ Arquitectura de Paquetes y Clases

### 📦 Código de Producción (`src/main/java/com/hielofriends/domain/`)

- **`PenguinPlush.java` (o `PlushOrder.java`):** Entidad principal de dominio que encapsula las reglas de negocio, modelos de pingüinos (Emperador, Adelia, Papúa, etc.), control de inventario y stock disponible.
- **`OutOfStockException.java`:** Excepción de dominio lanzada cuando se intenta realizar un pedido que excede el stock disponible de peluches.
- **`MessageNotifier.java` (o `OrderNotifier.java`):** Interfaz/Contrato para el envío desacoplado de notificaciones (confirmación de compra, preparación o despacho).
- **`OrderService.java` (o `PlushOrderService.java`):** Servicio de dominio que orquesta la validación de pedidos, reducción de existencias y activación de las notificaciones.

---

### 🧪 Código de Pruebas (`src/test/java/com/hielofriends/domain/`)

- **`PenguinPlushTest.java`:** Pruebas unitarias para la entidad principal, verificando flujos de compra exitosa, agotamiento de stock y validación de límites de cantidad.
- **`OrderServiceTest.java`:** Pruebas unitarias para el servicio de órdenes utilizando **Mockito** para aislar y verificar el comportamiento y las interacciones con el contrato `MessageNotifier`.

---

## Comandos de Ejecución (Maven)

### Compilar el proyecto
```bash
mvn clean compile
```
### ejecutar la suite de pruebas
```bash
mvn clean test
```
