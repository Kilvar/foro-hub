package com.alura.forohub.controller;

import com.alura.forohub.domain.entity.Usuario;
import com.alura.forohub.domain.service.UsuarioService;
import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosTokenLogin;
import com.alura.forohub.dto.DatosUsuario;
import com.alura.forohub.dto.LoginRequest;
import com.alura.forohub.infra.response.ResponseHandler;
import com.alura.forohub.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioServ;

    @Autowired
    TokenService tokenServ;

    @Autowired
    AuthenticationManager authManager;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<DatosUsuario> crearUsuario(@RequestBody @Valid CrearUsuarioRequest datosUsuario){

        return ResponseHandler.buildResponse("Usuario creado con exito", HttpStatus.CREATED,
                usuarioServ.crearUsuario(datosUsuario));

    }

    @PostMapping("/login")
    public ResponseEntity<DatosTokenLogin> iniciarSesion(@RequestBody @Valid LoginRequest datosLogin){
        var token = new UsernamePasswordAuthenticationToken(datosLogin.nombre(), datosLogin.contrasena());
        var auth = authManager.authenticate(token);

        return ResponseHandler.buildResponse("Usuario autenticado con exito", HttpStatus.OK,
                new DatosTokenLogin(tokenServ.generarToken((Usuario) auth.getPrincipal())));
    }
}
