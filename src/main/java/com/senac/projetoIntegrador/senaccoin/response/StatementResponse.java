package com.senac.projetoIntegrador.senaccoin.response;

import java.sql.Timestamp;

public class StatementResponse {
    private Timestamp date;
    private String observation;
    private Long transactionAmount;
    private int status;

    

    public StatementResponse(Timestamp timestamp, String observation, Long transactionAmount, int status) {
        this.date = timestamp;
        this.observation = observation;
        this.transactionAmount = transactionAmount;
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
