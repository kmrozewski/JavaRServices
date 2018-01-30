package com.javar.scoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prediction {

    @JsonProperty
    private Double probability;

    @JsonProperty
    private String label;

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
}
