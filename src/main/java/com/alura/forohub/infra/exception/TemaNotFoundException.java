package com.alura.forohub.infra.exception;

import org.springframework.http.HttpStatus;

public class TemaNotFoundException extends CustomApiException{
    public TemaNotFoundException(Long id) {
        super("No se encontro el tema con el id: " + id, HttpStatus.NOT_FOUND);
    }
}
