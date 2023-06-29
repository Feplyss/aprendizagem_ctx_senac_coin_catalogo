package com.senac.projetoIntegrador.senaccoin.request;

public class NewTransactionRequest {
    private String observation;
    private Long amount;
    private int status;
    private Long senacCoinId;
    private String userId;

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getSenacCoinId() {
        return this.senacCoinId;
    }

    public void setSenacCoinId(Long senacCoinId) {
        this.senacCoinId = senacCoinId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
