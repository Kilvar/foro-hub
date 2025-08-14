package com.alura.forohub.dto;

import com.alura.forohub.domain.entity.EstadoTema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarTemaRequest(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        EstadoTema estado
) {
}
