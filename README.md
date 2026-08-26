# HieloFriends - Backend Microservicio (Hitos 3 & 4)

Microservicio backend desarrollado en Java 21 con Spring Boot aplicando principios de Arquitectura Limpia, Diseño Guiado por el Dominio (DDD), persistencia relacional en PostgreSQL orquestada con Docker y documentación interactiva mediante OpenAPI/Swagger.

---

## 🛠️ Pila Tecnológica

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3
* **Persistencia:** Spring Data JPA & PostgreSQL 16
* **Virtualización:** Docker & Docker Compose
* **Documentación:** SpringDoc OpenAPI 3 / Swagger-UI
* **Testing:** JUnit 5 & Mockito

---

## 🏗️ Arquitectura y Estructura del Proyecto

El sistema sigue una separación estricta de responsabilidades por capas concéntricas[cite: 1]:

* `domain` (Java Puro, cero dependencias externas):
  * `entity`: Entidades con identidad única y reglas de negocio encapsuladas (`PenguinPlush`, `Customer`).
  * `valueobject`: Tipos inmutables y auto-validantes implementados con `record` (`Email`, `PlushPrice`).
  * `exception`: Excepciones explícitas de negocio (`OutOfStockException`, `InvalidEmailException`).
  * `repository`: Contratos abstractos de persistencia (`PenguinPlushRepository`).
* `application` (Orquestación del negocio):
  * `usecase`: Casos de uso cohesivos desacoplados mediante inyección por constructor (`CreatePlushOrderUseCase`, `GetPenguinCatalogUseCase`).
* `infrastructure` (Detalles técnicos y adaptadores externos):
  * `web`: Controladores REST semánticos (`PenguinController`), DTOs anotados y manejador perimetral de errores (`GlobalExceptionHandler` con `@RestControllerAdvice`).
  * `persistence`: Entidades JPA (`PenguinPlushEntity`), repositorios de Spring Data (`PenguinJpaRepository`) y adaptadores concretos (`PostgresPenguinRepository`).
  * `config`: Configuraciones técnicas y beans de casos de uso.

---

## 🚀 Instrucciones de Ejecución

### 1. Iniciar la Base de Datos PostgreSQL
```bash
docker compose up -d

### 2. Ejecutar la Aplicación en Modo Desarrollo
```bash
./mvnw spring-boot:run
*(En Windows también es válido `mvn spring-boot:run`)*

### 3. Ejecutar Pruebas Automatizadas
```bash
mvn clean test