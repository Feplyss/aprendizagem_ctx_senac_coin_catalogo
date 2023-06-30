package com.senac.projetoIntegrador.catalogo.exceptions;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.senac.projetoIntegrador.catalogo.response.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(InvalidCursoPeriodoException.class)
    public ResponseEntity<StandardError> invalidCursoPeriodo(InvalidCursoPeriodoException ex, HttpServletRequest request){
        StandardError errors = new StandardError(new Timestamp(System.currentTimeMillis()), HttpStatus.FORBIDDEN.value(), "Validation error", "Periodo ou Curso não encontrado.", request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Error parsing JSON", e.getMessage(), null));
    }
}
