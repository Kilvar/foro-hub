package com.alura.forohub.domain.repository;

import com.alura.forohub.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
