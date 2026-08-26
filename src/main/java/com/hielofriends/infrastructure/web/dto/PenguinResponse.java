package com.hielofriends.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos públicos del modelo de peluche de pingüino")
public record PenguinResponse(
    @Schema(example = "peng-01", description = "Identificador único del peluche")
    String id,

    @Schema(example = "Pingüino Emperador", description = "Nombre del modelo")
    String model,

    @Schema(example = "15990.0", description = "Precio unitario")
    double price,

    @Schema(example = "CLP", description = "Moneda del precio")
    String currency,

    @Schema(example = "10", description = "Unidades disponibles en inventario")
    int availableStock
) {}