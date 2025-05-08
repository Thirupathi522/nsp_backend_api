package com.nlc.nps.entity;
public class NpsTransactionResponse {
    private int trxSeq;
    private int points;

    // Constructors
    public NpsTransactionResponse(int trxSeq, int points) {
        this.trxSeq = trxSeq;
        this.points = points;
    }

    // Getters and setters
    public int getTrxSeq() {
        return trxSeq;
    }

    public void setTrxSeq(int trxSeq) {
        this.trxSeq = trxSeq;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
