package com.javar.classification.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomForestRequest {

    @JsonProperty("data")
    @NotNull
    private IrisDataFrame dataFrame;

    public IrisDataFrame getDataFrame() {
        return dataFrame;
    }

    public void setDataFrame(IrisDataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }
}
