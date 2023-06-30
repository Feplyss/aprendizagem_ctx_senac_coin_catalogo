package com.senac.projetoIntegrador.catalogo.exceptions;

public class InvalidCursoPeriodoException extends Exception{
    public InvalidCursoPeriodoException(String errorMsg){
        super(errorMsg);
    }

    public InvalidCursoPeriodoException() {
    }
}
