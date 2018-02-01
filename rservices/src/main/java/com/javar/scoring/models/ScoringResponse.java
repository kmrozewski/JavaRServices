package com.javar.scoring.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ScoringResponse {

    @JsonProperty
    private long id;

    @JsonProperty
    @NotNull
    private Prediction[] prediction;

    public long getId() {
        return id;
    }

    public ScoringResponse setId(long id) {
        this.id = id;

        return this;
    }

    public Prediction[] getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction[] prediction) {
        this.prediction = prediction;
    }
}
