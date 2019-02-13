package com.prediction.tracker.predictionTracker.services;

import com.prediction.tracker.predictionTracker.entities.BetCounter;
import org.springframework.stereotype.Service;
import com.prediction.tracker.predictionTracker.entities.Prediction;
import com.prediction.tracker.predictionTracker.models._Prediction;
import com.prediction.tracker.predictionTracker.repositories.PredictionRepository;
import com.prediction.tracker.predictionTracker.utils.CustomExceptions;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ngunawardena on 2/13/2019.
 */

@Service
public class StatisticsService {

    @Autowired
    private PredictionRepository predictionRepo;

    public String calculateProfitLoss(){
//        List<Prediction> allPredictionsList=new ArrayList<>();
        try {
            predictionRepo.findAll().forEach(prediction -> {
                if (prediction.getIsCorrect().equalsIgnoreCase("yes")) {
                    prediction.setProfitOrLoss(prediction.getBetAmount() * prediction.getBetOdds());
                }
                if (prediction.getIsCorrect().equalsIgnoreCase("no")) {
                    prediction.setProfitOrLoss(prediction.getBetAmount() - (prediction.getBetAmount() * 2));
                }
                if (prediction.getIsCorrect().equalsIgnoreCase("cancel")) {
                    prediction.setProfitOrLoss(prediction.getBetAmount());
                }
//            allPredictionsList.add(component);
            });
            return "Success";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Failed";
        }
    }

    public BetCounter betAccuracy(){
        BetCounter betCounter = new BetCounter();
        try{
            predictionRepo.findAll().forEach(prediction -> {
                betCounter.setTotalBets(betCounter.getTotalBets()+1);
                if(prediction.getIsCorrect().equalsIgnoreCase("yes")){
                    betCounter.setCorrectBets(betCounter.getCorrectBets()+1);
                }
                if(prediction.getIsCorrect().equalsIgnoreCase("no")){
                    betCounter.setWrongBets(betCounter.getWrongBets()+1);
                }
                if(!(prediction.getIsCorrect().equalsIgnoreCase("yes")) && !(prediction.getIsCorrect().equalsIgnoreCase("no"))){
                    betCounter.setUnconfirmedBets(betCounter.getUnconfirmedBets()+1);
                }
            });
            double totalBetsExcludingUnconfirmed = ((double)(betCounter.getTotalBets())-betCounter.getUnconfirmedBets());
            double totalCorrectBetPercentage = ((double)betCounter.getCorrectBets()/totalBetsExcludingUnconfirmed);
            betCounter.setCorrectBetPercentage(totalCorrectBetPercentage*100);
            return betCounter;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new CustomExceptions("Failed");
        }
    }
}
