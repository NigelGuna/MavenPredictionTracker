package com.prediction.tracker.predictionTracker.entities;

/**
 * Created by ngunawardena on 2/13/2019.
 */
public class BetCounter {
    private int totalBets = 0;
    private int correctBets = 0;
    private int wrongBets = 0;
    private int unconfirmedBets = 0;
    private double correctBetPercentage = 0;

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    public int getCorrectBets() {
        return correctBets;
    }

    public void setCorrectBets(int correctBets) {
        this.correctBets = correctBets;
    }

    public int getWrongBets() {
        return wrongBets;
    }

    public void setWrongBets(int wrongBets) {
        this.wrongBets = wrongBets;
    }

    public int getUnconfirmedBets() {
        return unconfirmedBets;
    }

    public void setUnconfirmedBets(int unconfirmedBets) {
        this.unconfirmedBets = unconfirmedBets;
    }

    public double getCorrectBetPercentage() {
        return correctBetPercentage;
    }

    public void setCorrectBetPercentage(double correctBetPercentage) {
        this.correctBetPercentage = correctBetPercentage;
    }
}
