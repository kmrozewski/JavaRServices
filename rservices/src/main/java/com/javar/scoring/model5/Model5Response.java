package com.javar.scoring.model5;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model5Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    @Getter
    private Model5DataFrame inputData;

    @Override
    public Model5Response setId(long id) {
        super.setId(id);

        return this;
    }
}
