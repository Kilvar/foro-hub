package com.alura.forohub.controller;

import com.alura.forohub.domain.entity.Curso;
import com.alura.forohub.domain.repository.CursoRepository;
import com.alura.forohub.dto.CrearCursoRequest;
import com.alura.forohub.dto.DatosCurso;
import com.alura.forohub.exception.CursoNotFoundException;
import com.alura.forohub.response.ResponseHandler;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cursos")
public class CursoController {

    @Autowired
    CursoRepository repo;

    @PostMapping("/")
    @Transactional
    public ResponseEntity<DatosCurso> crearCurso(@RequestBody CrearCursoRequest datosCurso){

        return ResponseHandler.buildResponse("Curso creado con exito", HttpStatus.CREATED,
                repo.save(new Curso(datosCurso)).getDTO());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarCurso(@PathVariable Long id){
        Curso c = repo.findById(id).orElseThrow(()-> new CursoNotFoundException(id));
        String nombre = c.getNombreCurso();
        repo.deleteById(id);
        return ResponseHandler.buildResponse("Curso eliminado con exito: " + nombre, HttpStatus.NO_CONTENT,
                null);
    }
}
