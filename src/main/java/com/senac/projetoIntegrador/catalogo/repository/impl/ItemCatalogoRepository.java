package com.senac.projetoIntegrador.catalogo.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.senac.projetoIntegrador.catalogo.dto.ItemCatalogoDto;
import com.senac.projetoIntegrador.catalogo.exceptions.InvalidCursoPeriodoException;
import com.senac.projetoIntegrador.catalogo.repository.IItemCatalogoRepository;

@Repository
public class ItemCatalogoRepository implements IItemCatalogoRepository{
    private JdbcTemplate dbConnection;

    @Autowired
    Queries queries;

    private class ItemCatalogoMapper implements RowMapper<ItemCatalogoDto>{
        @Override
        public ItemCatalogoDto mapRow(ResultSet rs, int rowNum) throws SQLException{
            ItemCatalogoDto itemCatalogoDto = new ItemCatalogoDto();
            itemCatalogoDto.setTitulo(rs.getString("item_catalogo_titulo"));
            itemCatalogoDto.setDescricao(rs.getString("item_catalogo_descricao"));
            itemCatalogoDto.setValor(rs.getLong("item_catalogo_valor"));
            itemCatalogoDto.setImagem(rs.getBytes("item_catalogo_imagem"));
            return itemCatalogoDto;
        }
    }

    @Autowired
    private void dbConnection(@Qualifier("dbConnection") DataSource dbConn){
        this.dbConnection = new JdbcTemplate(dbConn);
    }

    public List<ItemCatalogoDto> getItensByCursoPeriodo(Long periodoId, Long cursoId) throws InvalidCursoPeriodoException{
        List<ItemCatalogoDto> query = dbConnection.query(queries.getGetItensByCursoPeriodo(), new ItemCatalogoMapper(), new Object[] {periodoId, cursoId});
        if(query.size() == 0){
            throw new InvalidCursoPeriodoException();
        }
        return query;
    }

    @Async("asyncExecutor")
    public CompletableFuture<Integer> addItem(ItemCatalogoDto item) throws InvalidCursoPeriodoException{
        int numberOfRows;
        try{
            numberOfRows = this.dbConnection.update(queries.getInsertItem(), new Object[]{
            item.getTitulo(),
            item.getDescricao(),
            item.getValor(),
            item.getImagem(),
            item.getPeriodoId(),
            item.getCursoId()
        });
        }catch(DataIntegrityViolationException e){
            throw new InvalidCursoPeriodoException();
        }

        return CompletableFuture.completedFuture(Integer.valueOf(numberOfRows));
    }
}
