package com.alura.forohub.controller;

import com.alura.forohub.domain.service.TemaService;
import com.alura.forohub.dto.ActualizarTemaRequest;
import com.alura.forohub.dto.CrearTemaRequest;
import com.alura.forohub.dto.DatosTema;
import com.alura.forohub.infra.response.ResponseHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/temas")
public class TemaController {

    @Autowired
    TemaService service;

    @PostMapping("/")
    public ResponseEntity<DatosTema> crearTema(@RequestBody @Valid CrearTemaRequest datosTema){
        return ResponseHandler.buildResponse("Tema creado con exito", HttpStatus.CREATED,
                service.crearTema(datosTema));

    }

    @GetMapping("/listar")
    public ResponseEntity<Page<DatosTema>> listarTemas(@PageableDefault() Pageable paginacion){
        return ResponseHandler.buildResponse("Lista de temas obtenida con exito", HttpStatus.OK,
                service.listarTemas(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosTema> obtenerTema(@PathVariable Long temaId){
        return ResponseHandler.buildResponse("Tema obtenido con exito", HttpStatus.OK,
                service.obtenerTema(temaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosTema> actualizarTema(@PathVariable Long temaId, @RequestBody @Valid ActualizarTemaRequest datosTema) {
        return ResponseHandler.buildResponse("Tema actualizado con exito", HttpStatus.OK,
                service.actualizarTema(temaId, datosTema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTema(@PathVariable Long temaId) {
        String nombre = service.eliminarTema(temaId);
        return ResponseHandler.buildResponse("Tema eliminado con exito: " + nombre, HttpStatus.NO_CONTENT,
                null);
    }
}
