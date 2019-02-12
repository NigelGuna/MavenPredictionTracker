package com.prediction.tracker.predictionTracker.repositories;

import java.util.List;

import com.prediction.tracker.predictionTracker.entities.Prediction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ngunawardena on 2/12/2019.
 */
@Repository
public interface PredictionRepository extends CrudRepository<Prediction, Integer>{
    @Query(value = "SELECT p FROM prediction p", nativeQuery = true)
    List <Prediction> findPredictions(Pageable pageRequest);
}
