package com.javar.scoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoringResponse {

    @JsonProperty
    private ModelDataFrame inputData;

    @JsonProperty
    private Prediction prediction;

    @JsonProperty
    private Timing[] timings;

    public ModelDataFrame getInputData() {
        return inputData;
    }

    public void setInputData(ModelDataFrame inputData) {
        this.inputData = inputData;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }

    public Timing[] getTimings() {
        return timings;
    }

    public void setTimings(Timing[] timings) {
        this.timings = timings;
    }
}
