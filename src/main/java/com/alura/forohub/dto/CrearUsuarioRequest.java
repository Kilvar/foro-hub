package com.alura.forohub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioRequest(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        String contrasena,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email
) {
}
