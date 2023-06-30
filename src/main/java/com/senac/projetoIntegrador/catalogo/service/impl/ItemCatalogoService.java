package com.senac.projetoIntegrador.catalogo.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.projetoIntegrador.catalogo.dto.ItemCatalogoDto;
import com.senac.projetoIntegrador.catalogo.exceptions.InvalidCursoPeriodoException;
import com.senac.projetoIntegrador.catalogo.repository.IItemCatalogoRepository;
import com.senac.projetoIntegrador.catalogo.request.NewItemRequest;
import com.senac.projetoIntegrador.catalogo.service.IItemCatalogoService;

@Service
public class ItemCatalogoService implements IItemCatalogoService{
    @Autowired
    IItemCatalogoRepository repository;

    public List<ItemCatalogoDto> getItensByCursoPeriodo(Long periodoId, Long cursoId) throws InvalidCursoPeriodoException{
        return repository.getItensByCursoPeriodo(periodoId, cursoId);
    }

    public void addNewItem(NewItemRequest item) throws InvalidCursoPeriodoException{
        ItemCatalogoDto itemCatalogoDto = new ItemCatalogoDto(
            item.getTitulo(),
            item.getDescricao(),
            item.getValor(),
            item.getImagem(),
            item.getPeriodoId(),
            item.getCursoId()
        );

        CompletableFuture<Integer> addItem = repository.addItem(itemCatalogoDto);

        addItem.join();
    }
}
