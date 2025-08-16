package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String nombre,
        @NotBlank
        String contrasena
) {
}
