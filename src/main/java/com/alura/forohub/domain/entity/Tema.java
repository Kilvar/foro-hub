package com.alura.forohub.domain.entity;

import com.alura.forohub.dto.ActualizarTemaRequest;
import com.alura.forohub.dto.CrearTemaRequest;
import com.alura.forohub.dto.DatosTema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "Temas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long temaId;

    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoTema estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    public Tema(CrearTemaRequest datos, Usuario autor) {
        this.autor = autor;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoTema.ABIERTO;
    }

    public DatosTema getDTO(){
        return new DatosTema(temaId, titulo, mensaje, fechaCreacion, autor.getNombreUsuario());
    }

    public Tema actualizarDatos(ActualizarTemaRequest datos){
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.estado = datos.estado();
        return this;
    }
}
