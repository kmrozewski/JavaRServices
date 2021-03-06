package com.javar.scoring.model4;

import javax.validation.constraints.NotNull;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model4Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    @Getter
    private Model4DataFrame inputData;

    @Override
    public Model4Response setId(long id) {
        super.setId(id);

        return this;
    }
}
