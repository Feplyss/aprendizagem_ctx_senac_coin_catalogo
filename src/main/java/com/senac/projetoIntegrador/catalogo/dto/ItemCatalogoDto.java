package com.senac.projetoIntegrador.catalogo.dto;

public class ItemCatalogoDto {
    private Long id;
    private String titulo;
    private String descricao;
    private Long valor;
    private byte[] imagem;
    private Long periodoId;
    private Long cursoId;

    public ItemCatalogoDto() {
    }

    public ItemCatalogoDto(String titulo, String descricao, Long valor, byte[] imagem, Long periodoId, Long cursoId) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
        this.periodoId = periodoId;
        this.cursoId = cursoId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getValor() {
        return this.valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public byte[] getImagem() {
        return this.imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getPeriodoId() {
        return this.periodoId;
    }

    public void setPeriodoId(Long periodoId) {
        this.periodoId = periodoId;
    }

    public Long getCursoId() {
        return this.cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
