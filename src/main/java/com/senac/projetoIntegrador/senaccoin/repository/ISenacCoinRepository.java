package com.senac.projetoIntegrador.senaccoin.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.exceptions.BalanceNotFoundException;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;

public interface ISenacCoinRepository {
    public CompletableFuture<Integer> addMovement(SenacCoinMovimentacaoDto movement);
    public CompletableFuture<Integer> updateBalance(SenacCoinMovimentacaoDto movement) throws UserNotFoundException, BalanceNotFoundException;
    public List<SenacCoinMovimentacaoDto> getMovementsByUserId(String userId) throws UserNotFoundException;
    public Long getBalanceByUserId(String userId) throws UserNotFoundException;
}
