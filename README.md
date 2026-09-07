# 🐧 HieloFriends Core API - Backend Microservicio (Hitos 3 & 4)

Bienvenidos a **HieloFriends**, una plataforma diseñada para gestionar el catálogo y la venta exclusiva de peluches artesanales de pingüinos de colección. 

El objetivo de este microservicio es garantizar que cada orden de compra se procese respetando rigurosamente las reglas del mundo físico: control de stock en tiempo real, validación estricta de clientes y congelamiento de precios por modelo, asegurando una experiencia de compra confiable y sin sobreventas.

Construido en **Java 21** con **Spring Boot 3**, el sistema desacopla la lógica comercial mediante **Clean Architecture** y **Diseño Guiado por el Dominio (DDD)**, respaldado por persistencia transaccional en **PostgreSQL** sobre **Docker** y documentación interactiva mediante **OpenAPI/Swagger**.

---

## ❄️ El Dominio de Negocio

El corazón de HieloFriends modela el ciclo de vida comercial de los peluches:

* **Catálogo Antártico:** Cada peluche (`PenguinPlush`) posee un modelo registrado, un precio monetario inmutable (`PlushPrice`) y un inventario disponible.
* **Control de Stock Estricto:** No se permite vender unidades inexistentes ni aceptar cantidades negativas; cualquier exceso de demanda dispara excepciones de dominio explícitas (`OutOfStockException`).
* **Identidad del Cliente:** Toda reserva y orden vincula la identidad del comprador (`Customer`) verificando que su correo electrónico (`Email`) cumpla con formatos válidos antes de tocar la persistencia.

---

## Pila Tecnológica

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3
* **Persistencia:** Spring Data JPA & PostgreSQL 16 Alpine
* **Virtualización:** Docker & Docker Compose
* **Documentación:** SpringDoc OpenAPI 3 / Swagger-UI
* **Testing y Calidad:** JUnit 5, Mockito & JaCoCo

---

## Arquitectura y Estructura del Proyecto

El sistema sigue una separación estricta de responsabilidades por capas concéntricas:

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

## Instrucciones de Ejecución

### 1. Iniciar la Base de Datos PostgreSQL
```bash
docker compose up -d
```
### 2. Ejecutar la Aplicación en Modo Desarrollo
```bash
./mvnw spring-boot:run
```
*(En Windows también es válido `mvn spring-boot:run`)*
*API REST: http://localhost:8080/api/v1/penguins*
*Swagger UI (Dev): http://localhost:8080/swagger-ui.html*
### 3. Ejecutar Pruebas Automatizadas
```bash
mvn clean test
```
*(Para generar el reporte HTML de JaCoCo en target/site/jacoco/index.html ejecuta `mvn clean verify`)*