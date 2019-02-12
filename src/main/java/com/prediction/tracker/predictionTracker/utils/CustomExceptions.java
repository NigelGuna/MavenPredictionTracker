package com.prediction.tracker.predictionTracker.utils;

/**
 * Created by ngunawardena on 2/12/2019.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomExceptions extends RuntimeException{
    private String message;
    public CustomExceptions(String message) {
        super(message);
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
