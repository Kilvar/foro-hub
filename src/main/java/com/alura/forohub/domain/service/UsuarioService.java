package com.alura.forohub.domain.service;

import com.alura.forohub.domain.entity.Usuario;
import com.alura.forohub.domain.repository.UsuarioRepository;
import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosUsuario;
import com.alura.forohub.exception.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;

    @Transactional
    public DatosUsuario crearUsuario(CrearUsuarioRequest datos) {
        return repo.save(new Usuario(datos)).getDTO();
    }

    public Usuario buscarUsuarioPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new UsuarioNotFoundException(id));
    }
}
