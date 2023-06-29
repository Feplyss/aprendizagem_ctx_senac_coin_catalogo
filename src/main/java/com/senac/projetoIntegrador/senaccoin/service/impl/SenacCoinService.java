package com.senac.projetoIntegrador.senaccoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.senaccoin.dto.SenacCoinMovimentacaoDto;
import com.senac.projetoIntegrador.senaccoin.exceptions.BalanceNotFoundException;
import com.senac.projetoIntegrador.senaccoin.exceptions.InsuficientBalanceException;
import com.senac.projetoIntegrador.senaccoin.exceptions.UserNotFoundException;
import com.senac.projetoIntegrador.senaccoin.repository.ISenacCoinRepository;
import com.senac.projetoIntegrador.senaccoin.request.NewTransactionRequest;
import com.senac.projetoIntegrador.senaccoin.service.ISenacCoinService;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
public class SenacCoinService implements ISenacCoinService {

    @Autowired
    ISenacCoinRepository repository;


    public void addNewTRansaction(NewTransactionRequest transaction) throws UserNotFoundException, BalanceNotFoundException, InsuficientBalanceException{
        
        SenacCoinMovimentacaoDto senacCoinMovimentacaoDto = new SenacCoinMovimentacaoDto(
            new Timestamp(System.currentTimeMillis()),
            transaction.getObservation(),
            transaction.getAmount(),
            transaction.getStatus(),
            transaction.getSenacCoinId(),
            transaction.getUserId()
        );

        if (transaction.getStatus() == -1){
            Long userBalance = repository.getBalanceByUserId(transaction.getUserId());

            if (userBalance - transaction.getAmount() < 0 ){
                throw new InsuficientBalanceException("");
            }
        }
        
        CompletableFuture<Integer> addMovement = repository.addMovement(senacCoinMovimentacaoDto);
        CompletableFuture<Integer> updateBalance = repository.updateBalance(senacCoinMovimentacaoDto);

        CompletableFuture.allOf(addMovement, updateBalance).join();
        
    }

    public List<SenacCoinMovimentacaoDto> getSenacCoinStatement(String userId) throws UserNotFoundException{
        return repository.getMovementsByUserId(userId);
    }

    public Long getUserBalance(String userId) throws UserNotFoundException{
        return repository.getBalanceByUserId(userId);

    }
}
