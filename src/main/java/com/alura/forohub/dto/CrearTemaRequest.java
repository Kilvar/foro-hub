package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearTemaRequest(
        @NotNull
        Long usuarioId,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
        ) {

}
