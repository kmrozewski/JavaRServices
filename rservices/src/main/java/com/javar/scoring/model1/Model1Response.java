package com.javar.scoring.model1;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model1Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    @Getter
    private Model1DataFrame inputData;

    @Override
    public Model1Response setId(long id) {
        super.setId(id);

        return this;
    }
}
