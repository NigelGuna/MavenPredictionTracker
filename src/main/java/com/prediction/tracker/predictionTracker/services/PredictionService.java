package com.prediction.tracker.predictionTracker.services;

import com.prediction.tracker.predictionTracker.entities.Prediction;
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

    public Prediction addPrediction(Prediction prediction){
        try {
            return predictionRepo.save(prediction);
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

    public Prediction updatePrediction(int matchId, Prediction prediction){
        Optional<Prediction> foundPredictionId = predictionRepo.findById(matchId);
        if (foundPredictionId.isPresent()){
            Prediction foundPrediction = foundPredictionId.get();
            return predictionRepo.save(foundPrediction);
        }else{
            throw new CustomExceptions("Match not found");
        }
    }


}
