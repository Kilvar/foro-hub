package com.alura.forohub.infra.exception;

import org.springframework.http.HttpStatus;

public class UsuarioNotFoundException extends CustomApiException {
    public UsuarioNotFoundException(Long id) {
        super("No se encontro el usuario con el id: " + id,
                HttpStatus.NOT_FOUND);
    }
}
