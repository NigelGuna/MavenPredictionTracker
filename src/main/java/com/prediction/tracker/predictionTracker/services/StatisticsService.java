package com.prediction.tracker.predictionTracker.services;

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
        return "";
    }
}
