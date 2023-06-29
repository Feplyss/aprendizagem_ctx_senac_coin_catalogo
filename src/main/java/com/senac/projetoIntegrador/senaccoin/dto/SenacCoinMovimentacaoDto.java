package com.senac.projetoIntegrador.senaccoin.dto;

import java.sql.Timestamp;

public class SenacCoinMovimentacaoDto {
    private Long senacCoinMovimentacaoId;
    private Timestamp senacCoinMovimentacaoDate;
    private String senacCoinMovimentacaoObservacao;
    private Long senacCoinMovimentacaoValor;
    private int senacCoinMovimentacaoStatus;
    private Long senacCoinId;
    private String usuarioId;

    public SenacCoinMovimentacaoDto(Timestamp senacCoinMovimentacaoDate,
            String senacCoinMovimentacaoObservacao, Long senacCoinMovimentacaoValor,
            int senacCoinMovimentacaoStatus, Long senacCoinId, String usuarioId) {
        this.senacCoinMovimentacaoDate = senacCoinMovimentacaoDate;
        this.senacCoinMovimentacaoObservacao = senacCoinMovimentacaoObservacao;
        this.senacCoinMovimentacaoValor = senacCoinMovimentacaoValor;
        this.senacCoinMovimentacaoStatus = senacCoinMovimentacaoStatus;
        this.senacCoinId = senacCoinId;
        this.usuarioId = usuarioId;
    }
    

    public SenacCoinMovimentacaoDto(Long senacCoinMovimentacaoId, Timestamp senacCoinMovimentacaoDate,
            String senacCoinMovimentacaoObservacao, Long senacCoinMovimentacaoValor,
            int senacCoinMovimentacaoStatus, String usuarioId) {
        this.senacCoinMovimentacaoId = senacCoinMovimentacaoId;
        this.senacCoinMovimentacaoDate = senacCoinMovimentacaoDate;
        this.senacCoinMovimentacaoObservacao = senacCoinMovimentacaoObservacao;
        this.senacCoinMovimentacaoValor = senacCoinMovimentacaoValor;
        this.senacCoinMovimentacaoStatus = senacCoinMovimentacaoStatus;
        this.usuarioId = usuarioId;
    }

    public SenacCoinMovimentacaoDto() {
    }

    public Long getSenacCoinMovimentacaoId() {
        return senacCoinMovimentacaoId;
    }

    public void setSenacCoinMovimentacaoId(Long senacCoinMovimentacaoId) {
        this.senacCoinMovimentacaoId = senacCoinMovimentacaoId;
    }

    public Timestamp getSenacCoinMovimentacaoDate() {
        return senacCoinMovimentacaoDate;
    }

    public void setSenacCoinMovimentacaoDate(Timestamp senacCoinMovimentacaoDate) {
        this.senacCoinMovimentacaoDate = senacCoinMovimentacaoDate;
    }

    public String getSenacCoinMovimentacaoObservacao() {
        return senacCoinMovimentacaoObservacao;
    }

    public void setSenacCoinMovimentacaoObservacao(String senacCoinMovimentacaoObservacao) {
        this.senacCoinMovimentacaoObservacao = senacCoinMovimentacaoObservacao;
    }

    public Long getSenacCoinMovimentacaoValor() {
        return senacCoinMovimentacaoValor;
    }

    public void setSenacCoinMovimentacaoValor(Long senacCoinMovimentacaoValor) {
        this.senacCoinMovimentacaoValor = senacCoinMovimentacaoValor;
    }

    public int getSenacCoinMovimentacaoStatus() {
        return senacCoinMovimentacaoStatus;
    }

    public void setSenacCoinMovimentacaoStatus(int senacCoinMovimentacaoStatus) {
        this.senacCoinMovimentacaoStatus = senacCoinMovimentacaoStatus;
    }

    public Long getSenacCoinId() {
        return this.senacCoinId;
    }

    public void setSenacCoinId(Long senacCoinId) {
        this.senacCoinId = senacCoinId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

}
