package com.javar.scoring.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InputDataRequest<T extends ModelDataFrame> {

    @JsonProperty("data")
    @NotNull
    private T dataFrame;

    public T getDataFrame() {
        return dataFrame;
    }

    public void setDataFrame(T dataFrame) {
        this.dataFrame = dataFrame;
    }
}
