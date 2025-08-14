package com.alura.forohub.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long usuarioId;
    String contrasena;
    String email;
}
