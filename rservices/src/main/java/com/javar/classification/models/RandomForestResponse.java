package com.javar.classification.models;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomForestResponse {

    @JsonProperty
    @JsonInclude(NON_NULL)
    private Double probability;

    @JsonProperty
    @JsonInclude(NON_NULL)
    private String label;

    @JsonProperty
    private IrisDataFrame inputData;

    @JsonProperty
    private String message;

    @JsonProperty
    private String timestamp;

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public IrisDataFrame getInputData() {
        return inputData;
    }

    public void setInputData(IrisDataFrame inputData) {
        this.inputData = inputData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
