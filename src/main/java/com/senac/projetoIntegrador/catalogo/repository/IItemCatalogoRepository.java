package com.senac.projetoIntegrador.catalogo.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.senac.projetoIntegrador.catalogo.dto.ItemCatalogoDto;
import com.senac.projetoIntegrador.catalogo.exceptions.InvalidCursoPeriodoException;

public interface IItemCatalogoRepository {
    public List<ItemCatalogoDto> getItensByCursoPeriodo(Long periodoId, Long cursoId) throws InvalidCursoPeriodoException;
    public CompletableFuture<Integer> addItem(ItemCatalogoDto item) throws InvalidCursoPeriodoException;
}
