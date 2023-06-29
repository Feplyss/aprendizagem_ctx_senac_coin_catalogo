package com.senac.projetoIntegrador.senaccoin.exceptions;

public class BalanceNotFoundException extends Exception{
    public BalanceNotFoundException(String errorMsg){
        super(errorMsg);
    }

    public BalanceNotFoundException() {
    }
}
