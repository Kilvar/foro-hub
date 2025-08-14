package com.alura.forohub.dto;

import java.time.LocalDateTime;

public record DatosTema(
        Long temaId,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor
) {
}
