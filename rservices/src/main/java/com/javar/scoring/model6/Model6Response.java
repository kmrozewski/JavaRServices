package com.javar.scoring.model6;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model6Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    @Getter
    private Model6DataFrame inputData;

    @Override
    public Model6Response setId(long id) {
        super.setId(id);

        return this;
    }
}
