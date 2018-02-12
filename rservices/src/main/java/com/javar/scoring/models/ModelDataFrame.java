package com.javar.scoring.models;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ModelDataFrame {

    @JsonProperty("ID")
    @Getter
    @Setter
    private long id;
}
