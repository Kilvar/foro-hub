package com.alura.forohub.domain.service;

import com.alura.forohub.domain.entity.Usuario;
import com.alura.forohub.domain.repository.UsuarioRepository;
import com.alura.forohub.dto.CrearUsuarioRequest;
import com.alura.forohub.dto.DatosUsuario;
import com.alura.forohub.infra.exception.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository repo;

    @Transactional
    public DatosUsuario crearUsuario(CrearUsuarioRequest datos) {
        return repo.save(new Usuario(datos)).getDTO();
    }

    public Usuario buscarUsuarioPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new UsuarioNotFoundException(id));
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByNombreUsuario(username);
    }
}
