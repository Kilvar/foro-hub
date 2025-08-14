package com.alura.forohub.domain.repository;

import com.alura.forohub.domain.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
}
