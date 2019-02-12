package com.prediction.tracker.predictionTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class PredictionTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictionTrackerApplication.class, args);
	}

}

