package com.senac.projetoIntegrador.senaccoin.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<StandardError> userNotFound(EmptyResultDataAccessException ex, HttpServletRequest request){
        StandardError errors = new StandardError(new Timestamp(System.currentTimeMillis()), HttpStatus.FORBIDDEN.value(), "Validation error", "Usuário não encontrado.", request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardError> userNotFound(SQLIntegrityConstraintViolationException ex, HttpServletRequest request){
        StandardError errors = new StandardError(new Timestamp(System.currentTimeMillis()), HttpStatus.FORBIDDEN.value(), "Validation error", "Id do Usuário ou SenacCoin inválido.", request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }

    @ExceptionHandler(InsuficientBalanceException.class)
    public ResponseEntity<StandardError> insuficientBalance(InsuficientBalanceException ex, HttpServletRequest request){
        StandardError errors = new StandardError(new Timestamp(System.currentTimeMillis()), HttpStatus.FORBIDDEN.value(), "Invalid value error", "Saldo insuficiente para realizar a transação.", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errors);
    }
}
