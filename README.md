# HieloFriends - Backend Arquitectura Limpia (Hito 3)

Backend modular desarrollado en Java puro aplicando principios de Arquitectura Limpia y Diseño Guiado por el Dominio (DDD) para la plataforma de venta de peluches de pingüinos HieloFriends.

---

## 🏗️ Mapa de Paquetes y Capas

- `com.hielofriends.domain`: Núcleo de negocio en Java puro, libre de anotaciones o dependencias de frameworks externos.
  - `entity`: Modelos ricos en comportamiento con identidad única (`PenguinPlush`, `Customer`).
  - `valueobject`: Tipos inmutables y auto-validantes implementados con `record` (`Email`, `PlushPrice`).
  - `exception`: Excepciones de dominio explícitas (`OutOfStockException`, `InvalidEmailException`).
  - `repository`: Contratos abstractos de persistencia (`PenguinPlushRepository`).
- `com.hielofriends.application`: Orquestación de lógica de negocio mediante casos de uso desacoplados con inyección de dependencias por constructor.
  - `usecase`: `CreatePlushOrderUseCase`, `GetPenguinCatalogUseCase`.
- `com.hielofriends.infrastructure`: Adaptadores técnicos y detalles de implementación.
  - `persistence`: Implementación en memoria del contrato de repositorio (`InMemoryPenguinRepository`).

---

## 🧪 Instrucciones de Compilación y Pruebas

- **Compilar y verificar el proyecto:**
  ```bash
  mvn clean compile

- **Ejecutar la suite de pruebas unitarias:**
  ```bash
  mvn test
  