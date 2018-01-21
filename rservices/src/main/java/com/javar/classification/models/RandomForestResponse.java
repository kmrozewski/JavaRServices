package com.javar.classification.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomForestResponse {

    @JsonProperty
    private InputData inputData;

    @JsonProperty
    private PredictResultsResponse[] predictResults;

    public InputData getInputData() {
        return inputData;
    }

    public void setInputData(InputData inputData) {
        this.inputData = inputData;
    }

    public PredictResultsResponse[] getPredictResults() {
        return predictResults;
    }

    public void setPredictResults(PredictResultsResponse[] predictResults) {
        this.predictResults = predictResults;
    }
}
