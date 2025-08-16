package com.alura.forohub.infra.exception;

import org.springframework.http.HttpStatus;

public class CursoNotFoundException extends CustomApiException {
    public CursoNotFoundException(Long id) {
        super("No se encontro un curso con el id: " + id, HttpStatus.NOT_FOUND);
    }
}
