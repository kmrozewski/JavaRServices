package com.javar.scoring.model1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoringResponse {

    @JsonProperty
    private DataFrame inputData;

    @JsonProperty
    private Predict predict;

    @JsonProperty
    private Timing[] timings;

    public DataFrame getInputData() {
        return inputData;
    }

    public void setInputData(DataFrame inputData) {
        this.inputData = inputData;
    }

    public Predict getPredict() {
        return predict;
    }

    public void setPredict(Predict predict) {
        this.predict = predict;
    }

    public Timing[] getTimings() {
        return timings;
    }

    public void setTimings(Timing[] timings) {
        this.timings = timings;
    }
}
