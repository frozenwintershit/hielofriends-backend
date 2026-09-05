package com.hielofriends.infrastructure.web.controller;

import com.hielofriends.application.usecase.CreatePlushOrderUseCase;
import com.hielofriends.application.usecase.GetPenguinCatalogUseCase;
import com.hielofriends.domain.entity.PenguinPlush;
import com.hielofriends.domain.valueobject.Email;
import com.hielofriends.infrastructure.web.dto.CreateOrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/penguins")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@Tag(name = "Penguins", description = "Catálogo y pedidos de peluches de pingüinos")
public class PenguinController {

    private final GetPenguinCatalogUseCase getCatalogUseCase;
    private final CreatePlushOrderUseCase createOrderUseCase;

    public PenguinController(GetPenguinCatalogUseCase getCatalogUseCase, CreatePlushOrderUseCase createOrderUseCase) {
        this.getCatalogUseCase = getCatalogUseCase;
        this.createOrderUseCase = createOrderUseCase;
    }

    @GetMapping
    @Operation(summary = "Obtener catálogo", description = "Retorna la lista de todos los peluches disponibles")
    public ResponseEntity<List<PenguinPlush>> getCatalog() {
        return ResponseEntity.ok(getCatalogUseCase.execute()); // 200 OK
    }

    @PostMapping("/orders")
    @Operation(summary = "Realizar orden de compra", description = "Reduce el stock del peluche y genera la compra")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest request) {
        createOrderUseCase.execute(
            request.plushId(),
            request.quantity(),
            new Email(request.customerEmail())
        );
        return new ResponseEntity<>(HttpStatus.CREATED); // 201 Created
    }
}
