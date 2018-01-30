package com.javar.scoring.model1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Predict {

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
