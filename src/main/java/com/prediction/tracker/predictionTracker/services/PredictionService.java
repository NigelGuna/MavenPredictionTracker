package com.prediction.tracker.predictionTracker.services;

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
 * Created by ngunawardena on 2/12/2019.
 */
@Service
public class PredictionService {

    @Autowired
    private PredictionRepository predictionRepo;

    private List <Prediction> predictionsList;

    public List<Prediction> getAllPredictions(int page, int size){
        predictionsList = new ArrayList<>();
        predictionRepo.findAll().forEach(predictionsList::add);
        return predictionRepo.findPredictions(new PageRequest(page, size));
    }

    public Prediction addPrediction(_Prediction _prediction){
        try {
            return predictionRepo.save(assemblePredictionModel(_prediction));
        }catch (Exception e){
            throw new CustomExceptions("Error encountered. Could not save prediction.");
        }
    }

    public String deletePrediction(int matchId){
        try{
            predictionRepo.deleteById(matchId);
            return "Prediction with the ID: " + matchId + " has been deleted successfully";
        }catch(IllegalArgumentException e){
            return "The prediction ID: "+ matchId + " couldn't be found";
        }
    }

    public Prediction getOnePrediction(int matchId){
        Optional<Prediction> foundPredictionId = predictionRepo.findById(matchId);
        if (foundPredictionId.isPresent()){
            Prediction foundPrediction = foundPredictionId.get();
            return foundPrediction;
        }
        else{
            throw new CustomExceptions("Match not found");
        }
    }

    public Prediction updatePrediction(int matchId, _Prediction _prediction){
        Optional<Prediction> foundPredictionId = predictionRepo.findById(matchId);
        if (foundPredictionId.isPresent()){
            // Create found prediction
            Prediction foundPrediction = foundPredictionId.get();
            // Validations
            if(!(_prediction.getTeamOne().equals("string")) && !(_prediction.getTeamOne()==null)){
                foundPrediction.setTeamOne(_prediction.getTeamOne());
            }
            if(!(_prediction.getTeamTwo().equals("string")) && !(_prediction.getTeamTwo()==null)){
                foundPrediction.setTeamTwo(_prediction.getTeamTwo());
            }
            if(!(_prediction.getPrediction().equals("string")) && !(_prediction.getPrediction()==null)){
                foundPrediction.setPrediction(_prediction.getPrediction());
            }
            if(!(_prediction.getOtherNotes().equals("string")) && !(_prediction.getOtherNotes()==null)){
                foundPrediction.setOtherNotes(_prediction.getOtherNotes());
            }

            // Other changes
            foundPrediction.setBetAmount(_prediction.getBetAmount());
            foundPrediction.setIsCorrect(_prediction.getIsCorrect());

            return predictionRepo.save(foundPrediction);
        }else{
            throw new CustomExceptions("Match not found");
        }
    }

    public Prediction assemblePredictionModel(_Prediction _prediction){
        Prediction prediction = new Prediction();

        prediction.setMatchDate(_prediction.getMatchDate());
        prediction.setTeamOne(_prediction.getTeamOne());
        prediction.setTeamTwo(_prediction.getTeamTwo());
        prediction.setPrediction(_prediction.getPrediction());
        prediction.setIsCorrect(_prediction.getIsCorrect());
        prediction.setBetAmount(_prediction.getBetAmount());
        prediction.setOtherNotes(_prediction.getOtherNotes());
        prediction.setBetOdds(_prediction.getBetOdds());

        return prediction;
    }


}
