package com.javar.scoring.models;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class Prediction {

    @JsonProperty
    private double probability;

    @JsonProperty
    private String label;
}
