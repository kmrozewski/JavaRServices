package com.javar.scoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prediction {

    @JsonProperty
    private double probability;

    @JsonProperty
    private String label;

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
