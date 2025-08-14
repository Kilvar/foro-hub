package com.alura.forohub.controller;

import com.alura.forohub.domain.entity.Usuario;
import com.alura.forohub.domain.repository.UsuarioRepository;
import com.alura.forohub.domain.service.UsuarioService;
import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosUsuario;
import com.alura.forohub.response.ResponseHandler;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping("/")
    @Transactional
    public ResponseEntity<DatosUsuario> crearUsuario(@RequestBody @Valid CrearUsuarioRequest datosUsuario){

        return ResponseHandler.buildResponse("Usuario creado con exito", HttpStatus.CREATED,
                service.crearUsuario(datosUsuario));

    }
}
