package com.prediction.tracker.predictionTracker.controllers;

/**
 * Created by ngunawardena on 2/12/2019.
 */

import com.prediction.tracker.predictionTracker.entities.Prediction;
import com.prediction.tracker.predictionTracker.models._Prediction;
import com.prediction.tracker.predictionTracker.services.PredictionService;
import com.prediction.tracker.predictionTracker.utils.CustomExceptions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
//@RequestMapping("/prediction")
@Api(value = "prediction", description = "An API for Match Prediction Tracking", tags = "PredictionTracking API")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping(value = "/prediction")
    @ApiOperation(value = "Get all predictions", response = Prediction.class)
    public List<Prediction> listAllPredictions(@RequestParam(required = true) int page, @RequestParam(required = true) int size) {
        return predictionService.getAllPredictions(page, size);
    }

    @PostMapping("/prediction")
    @ApiOperation(value = "Add a new Prediction", response = Prediction.class)
    public Prediction addPaymentLoan(@RequestBody _Prediction _prediction) {
        try {
            return predictionService.addPrediction(_prediction);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }

    @DeleteMapping("/prediction/{id}")
    @ApiOperation(value = "Delete the Prediction for a particular prediciton ID")
    public String deletePrediction(@PathVariable("id") int matchId) {
        return predictionService.deletePrediction(matchId);
    }

    @GetMapping(value = "/prediction/{id}")
    @ApiOperation(value = "Get one prediction", response = Prediction.class)
    public Prediction getOnePrediction(@PathVariable("id") int matchId) {
        return predictionService.getOnePrediction(matchId);
    }

    @PutMapping("/prediction/{id}")
    @ApiOperation(value = "Update the prediction info for a particular prediction ID", response = Prediction.class)
    public Prediction updatePrediction(@PathVariable("id") int matchId, @RequestBody _Prediction _prediction) {
        try {
            return predictionService.updatePrediction(matchId, _prediction);
        } catch (Exception e) {
            throw new CustomExceptions(e.getMessage());
        }
    }
}
