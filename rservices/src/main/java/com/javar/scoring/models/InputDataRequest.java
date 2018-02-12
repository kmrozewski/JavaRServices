package com.javar.scoring.models;

import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputDataRequest<T> {

    @JsonProperty("data")
    @NotNull
    private T dataFrame;
}
