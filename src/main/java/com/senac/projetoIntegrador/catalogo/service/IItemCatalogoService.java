package com.senac.projetoIntegrador.catalogo.service;

import java.util.List;

import com.senac.projetoIntegrador.catalogo.dto.ItemCatalogoDto;
import com.senac.projetoIntegrador.catalogo.exceptions.InvalidCursoPeriodoException;
import com.senac.projetoIntegrador.catalogo.request.NewItemRequest;

public interface IItemCatalogoService {
    public List<ItemCatalogoDto> getItensByCursoPeriodo(Long periodoId, Long cursoId) throws InvalidCursoPeriodoException;
    public void addNewItem(NewItemRequest item) throws InvalidCursoPeriodoException;
}
