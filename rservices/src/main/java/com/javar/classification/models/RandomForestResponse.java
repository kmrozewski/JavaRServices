package com.javar.classification.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RandomForestResponse {

    @JsonProperty
    private InputData inputData;

    @JsonProperty
    private PredictResultsResponse[] predictResults;
}
