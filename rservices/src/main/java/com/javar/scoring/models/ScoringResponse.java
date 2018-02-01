package com.javar.scoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoringResponse<T extends ModelDataFrame> {

    @JsonProperty
    private T inputData;

    @JsonProperty
    private Prediction[] prediction;

    public T getInputData() {
        return inputData;
    }

    public void setInputData(T inputData) {
        this.inputData = inputData;
    }

    public Prediction[] getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction[] prediction) {
        this.prediction = prediction;
    }
}
