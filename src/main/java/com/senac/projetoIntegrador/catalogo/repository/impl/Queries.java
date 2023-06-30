package com.senac.projetoIntegrador.catalogo.repository.impl;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Queries {
    private String getItensByCursoPeriodo = """
                SELECT item_catalogo_titulo, item_catalogo_descricao, item_catalogo_valor, item_catalogo_imagem FROM item_catalogo 
                WHERE curso_id = ? AND periodo_id = ?;
            """;

    private String insertItem = """
                INSERT INTO item_catalogo(item_catalogo_titulo, item_catalogo_descricao, item_catalogo_valor, item_catalogo_imagem, periodo_id, curso_id)
                VALUES(?, ?, ?, ?, ?, ?);
            """;

    public String getGetItensByCursoPeriodo() {
        return this.getItensByCursoPeriodo;
    }

    public String getInsertItem(){
        return this.insertItem;
    }
}
