package com.alura.forohub.exception.handler;

import com.alura.forohub.exception.CustomApiException;
import com.alura.forohub.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {CustomApiException.class})
    public ResponseEntity<Object> handleException(CustomApiException e){
        return ResponseHandler.buildResponse(e.getMessage(), e.getReturnStatus(), null);
    }

    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> handleDBException(SQLException e){
        return ResponseHandler.buildResponse("Ocurrio un error de servidor, verifique los datos", HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

}
