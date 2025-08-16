package com.alura.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record CrearCursoRequest(
        @NotBlank
        String nombreCurso,
        @NotBlank
        String nombreCategoria)
{
}
