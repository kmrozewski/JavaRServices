package com.javar.scoring.models;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ScoringResponse {

    @JsonProperty
    @Getter
    private long id;

    @JsonProperty
    @NotNull
    @Getter
    @Setter
    private Prediction[] prediction;

    public ScoringResponse setId(long id) {
        this.id = id;

        return this;
    }
}
