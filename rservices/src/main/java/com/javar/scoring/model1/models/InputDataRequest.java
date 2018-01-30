package com.javar.scoring.model1.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InputDataRequest<T extends DataFrame> {

    @JsonProperty("data")
    @NotNull
    private T dataFrame;
}
