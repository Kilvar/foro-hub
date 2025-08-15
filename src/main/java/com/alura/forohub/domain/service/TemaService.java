package com.alura.forohub.domain.service;

import com.alura.forohub.domain.entity.Tema;
import com.alura.forohub.domain.repository.TemaRepository;
import com.alura.forohub.dto.ActualizarTemaRequest;
import com.alura.forohub.dto.CrearTemaRequest;
import com.alura.forohub.dto.DatosTema;
import com.alura.forohub.dto.DatosTemaEliminado;
import com.alura.forohub.exception.TemaNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {

    @Autowired
    TemaRepository repo;

    @Autowired
    UsuarioService uServ;

    @Transactional
    public DatosTema crearTema(CrearTemaRequest datosTema) {
        var u = uServ.buscarUsuarioPorId(datosTema.usuarioId());
        return repo.save(new Tema(datosTema, u)).getDTO();
    }

    public Page<DatosTema> listarTemas(Pageable paginacion) {
        return repo.findAll(paginacion).map(Tema::getDTO);
    }

    public DatosTema obtenerTema(Long temaId){
        return repo.findById(temaId)
                .orElseThrow(()-> new TemaNotFoundException(temaId))
                .getDTO();
    }

    @Transactional
    public DatosTema actualizarTema(Long temaId, ActualizarTemaRequest datosTema) {
        Tema t = repo.findById(temaId).orElseThrow(()-> new TemaNotFoundException(temaId));
        t.actualizarDatos(datosTema);
        return repo.save(t).getDTO();
    }

    @Transactional
    public String eliminarTema(Long temaId) {
        Tema t = repo.findById(temaId).orElseThrow(()-> new TemaNotFoundException(temaId));
        String nombreTema = t.getTitulo();
        repo.deleteById(temaId);
        return nombreTema;
    }
}
