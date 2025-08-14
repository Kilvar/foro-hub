package com.alura.forohub.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Temas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tema {

    Long temaId;
    String titulo;
    String mensaje;
    LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    EstadoTema estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario autor;
}
