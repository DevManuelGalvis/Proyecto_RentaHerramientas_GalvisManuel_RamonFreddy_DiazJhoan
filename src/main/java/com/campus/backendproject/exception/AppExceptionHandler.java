package com.campus.backendproject.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ConflictDbException.class)
    public ResponseEntity<MyError> manejoConflicto(ConflictDbException err, HttpServletRequest request){
        MyError cuerpo  = new MyError(LocalDateTime.now(), HttpStatus.CONFLICT.value(), "conflicto", request.getRequestURI(), err.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(cuerpo);
    }

    @ExceptionHandler(RegistroNoEncontradoException.class)
    public ResponseEntity<MyError> manejoNoEncontrado(RegistroNoEncontradoException ex, HttpServletRequest request){
        MyError cuerpo  = new MyError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not found", request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cuerpo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyError> manejoValidaciones (MethodArgumentNotValidException err, HttpServletRequest request){
        List<FieldError> listaErrores = err.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder("Erorres de validación: ");
        for(FieldError f: listaErrores){
            sb.append(f.getField()).append(" - ").append(f.getDefaultMessage()).append(" | ");
        }

        MyError cuerpo  = new MyError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad request", request.getRequestURI(), sb.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpo);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<MyError> manejoUnauthorized(UnauthorizedException ex, HttpServletRequest request){
        MyError cuerpo = new MyError(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), "Unauthorized", request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(cuerpo);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<MyError> manejoAccesoDenegado(AccessDeniedException ex, HttpServletRequest request) {
        MyError cuerpo = new MyError(LocalDateTime.now(), HttpStatus.FORBIDDEN.value(), "Forbidden", request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(cuerpo);
    }

    @ExceptionHandler(ResourceNotAvailableException.class)
    public ResponseEntity<MyError> manejoRecursoNoDisponible(ResourceNotAvailableException ex, HttpServletRequest request) {
        MyError cuerpo = new MyError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad request", request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpo);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<MyError> manejoReglaNegocio(BusinessRuleException ex, HttpServletRequest request) {
        MyError cuerpo = new MyError(LocalDateTime.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Unprocessable entity", request.getRequestURI(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(cuerpo);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError> manejoGeneral(Exception err, HttpServletRequest request){
        MyError cuerpo  = new MyError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error", request.getRequestURI(), "Ocurrió un error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(cuerpo);
    }
}