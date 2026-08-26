// CreateOrderRequest.java
package com.hielofriends.infrastructure.web.dto;
import io.swagger.v3.oas.annotations.media.Schema;

public record CreateOrderRequest(
    @Schema(example = "peng-01", description = "ID del peluche a comprar")
    String plushId,

    @Schema(example = "2", description = "Cantidad de unidades")
    int quantity,

    @Schema(example = "cliente@hielofriends.com", description = "Email de confirmación")
    String customerEmail
) {}