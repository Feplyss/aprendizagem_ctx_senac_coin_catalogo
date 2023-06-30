package com.senac.projetoIntegrador.catalogo.response;

public class ItensByCursoPeriodoResponse {
    private String titulo;
    private String descricao;
    private Long valor;
    private byte[] imagem;

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

    public ItensByCursoPeriodoResponse(String titulo, String descricao, Long valor, byte[] imagem) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }
    
}
