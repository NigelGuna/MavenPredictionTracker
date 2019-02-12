package com.prediction.tracker.predictionTracker.entities;

/**
 * Created by ngunawardena on 2/12/2019.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "february")
@NamedNativeQuery(name="february.findAll", query="SELECT p FROM february p")
public class Prediction {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int matchId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="match_date")
    private Date matchDate;

    @Column(name="team_one")
    private String teamOne;

    @Column(name="team_two")
    private String teamTwo;

    @Column(name="Prediction")
    private String prediction;

    @Column(name="is_correct")
    private String isCorrect;

    @Column(name="bet_amount")
    private int betAmount;

    @Column(name="profit_or_loss")
    private int profitOrLoss;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    public int getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(int profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }
}
