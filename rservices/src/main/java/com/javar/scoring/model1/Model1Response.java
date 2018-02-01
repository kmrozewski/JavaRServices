package com.javar.scoring.model1;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ScoringResponse;

public class Model1Response extends ScoringResponse {

    @JsonProperty("inputData")
    @NotNull
    private Model1DataFrame inputData;

    @Override
    public Model1Response setId(long id) {
        super.setId(id);

        return this;
    }

    public Model1DataFrame getInputData() {
        return inputData;
    }

    public void setInputData(Model1DataFrame inputData) {
        this.inputData = inputData;
    }
}
