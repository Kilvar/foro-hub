package com.alura.forohub.domain.entity;

import com.alura.forohub.dto.CrearCursoRequest;
import com.alura.forohub.dto.DatosCurso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cursos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cursoId;
    String nombreCurso;
    String nombreCategoria;

    public Curso(CrearCursoRequest datosCurso){
        this.nombreCurso = datosCurso.nombreCurso();
        this.nombreCategoria = datosCurso.nombreCategoria();
    }

    public DatosCurso getDTO(){
        return new DatosCurso(this.cursoId, this.nombreCurso, this.nombreCategoria);
    }
}
