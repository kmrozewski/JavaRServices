package com.javar.classification.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IrisDataFrame {

    @JsonProperty
    @NotNull
    private double sepalLength;

    @JsonProperty
    @NotNull
    private double sepalWidth;

    @JsonProperty
    @NotNull
    private String petalLength;

    @JsonProperty
    @NotNull
    private String petalWidth;

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public String getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(String petalLength) {
        this.petalLength = petalLength;
    }

    public String getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(String petalWidth) {
        this.petalWidth = petalWidth;
    }
}
