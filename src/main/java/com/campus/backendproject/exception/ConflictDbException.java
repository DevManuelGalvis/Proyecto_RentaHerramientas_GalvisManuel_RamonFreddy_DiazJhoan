package com.campus.backendproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictDbException extends RuntimeException{
    public ConflictDbException(String mensaje){
        super(mensaje);
    }
}
