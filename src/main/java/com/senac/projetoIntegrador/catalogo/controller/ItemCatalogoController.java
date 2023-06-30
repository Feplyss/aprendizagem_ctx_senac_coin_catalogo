package com.senac.projetoIntegrador.catalogo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.projetoIntegrador.catalogo.exceptions.InvalidCursoPeriodoException;
import com.senac.projetoIntegrador.catalogo.request.NewItemRequest;
import com.senac.projetoIntegrador.catalogo.response.ItensByCursoPeriodoResponse;
import com.senac.projetoIntegrador.catalogo.response.NewItemResponse;
import com.senac.projetoIntegrador.catalogo.service.IItemCatalogoService;



@RestController
@RequestMapping(value = "/catalogo", produces = "application/json")
public class ItemCatalogoController {
    @Autowired
    IItemCatalogoService service;

    @GetMapping("cursoPeriodo/{periodoId}/{cursoId}")
    public ResponseEntity<List<ItensByCursoPeriodoResponse>> retrieveItensByCursoPeriodo(@PathVariable(required = true, value = "periodoId") Long periodoId,
    @PathVariable(required = true, value = "cursoId") Long cursoId)throws InvalidCursoPeriodoException{
        List<ItensByCursoPeriodoResponse> listaItens = service.getItensByCursoPeriodo(periodoId, cursoId).stream()
            .map(item -> new ItensByCursoPeriodoResponse(
                item.getTitulo(),
                item.getDescricao(),
                item.getValor(),
                item.getImagem()))
            .collect(Collectors.toList());

        return new ResponseEntity<List<ItensByCursoPeriodoResponse>>(listaItens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewItemResponse> addNewItem(@RequestBody(required = true) NewItemRequest newItem) throws InvalidCursoPeriodoException{
        service.addNewItem(newItem);
        NewItemResponse response = new NewItemResponse();
        response.setStatus("OK");

        return new ResponseEntity<NewItemResponse>(response, HttpStatus.OK);
    }
}
