package com.senac.gestaocurso.enterprise.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationException extends RuntimeException {
    public ValidationException(String msg) {
        super(msg);
    }
}