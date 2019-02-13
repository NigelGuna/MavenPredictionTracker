package com.prediction.tracker.predictionTracker.controllers;

/**
 * Created by ngunawardena on 2/13/2019.
 */
import com.prediction.tracker.predictionTracker.entities.BetCounter;
import com.prediction.tracker.predictionTracker.entities.Prediction;
import com.prediction.tracker.predictionTracker.models._Prediction;
import com.prediction.tracker.predictionTracker.services.PredictionService;
import com.prediction.tracker.predictionTracker.services.StatisticsService;
import com.prediction.tracker.predictionTracker.utils.CustomExceptions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
@Api(value = "Statistics", description = "Prediction statistics", tags = "Statistics API")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(value = "/calculateProfitOrLoss")
    @ApiOperation(value = "Caluculate profit/loss", response = String.class)
    public String listAllPredictions() {
        return statisticsService.calculateProfitLoss();
    }

    @GetMapping(value = "/betAccuracy")
    @ApiOperation(value = "Caluculate the total number of correct and incorrect bets", response = String.class)
    public BetCounter betAccuracy() {
        return statisticsService.betAccuracy();
    }
}
