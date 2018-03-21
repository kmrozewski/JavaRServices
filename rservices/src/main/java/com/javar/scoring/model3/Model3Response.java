package com.javar.scoring.model3;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model3Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    @Getter
    private Model3DataFrame inputData;

    @Override
    public Model3Response setId(long id) {
        super.setId(id);

        return this;
    }
}
