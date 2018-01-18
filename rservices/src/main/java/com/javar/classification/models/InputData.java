package com.javar.classification.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputData {

    @JsonProperty
    private Double[] sepalLength;

    @JsonProperty
    private Double[] sepalWidth;

    @JsonProperty
    private String[] petalLength;

    @JsonProperty
    private String[] petalWidth;

    public Double[] getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(Double[] sepalLength) {
        this.sepalLength = sepalLength;
    }

    public Double[] getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(Double[] sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public String[] getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(String[] petalLength) {
        this.petalLength = petalLength;
    }

    public String[] getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(String[] petalWidth) {
        this.petalWidth = petalWidth;
    }
}
