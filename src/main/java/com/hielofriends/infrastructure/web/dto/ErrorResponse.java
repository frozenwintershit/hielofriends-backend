// ErrorResponse.java
package com.hielofriends.infrastructure.web.dto;
import java.time.LocalDateTime;

public record ErrorResponse(String message, String errorCode, LocalDateTime timestamp) {}