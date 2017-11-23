package com.javar.configuration;

import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RApplicationConfiguration extends Configuration {

    @NotNull
    @JsonProperty("rserve")
    private RServeConfiguration rServeConfiguration;

    public RServeConfiguration getrServeConfiguration() {
        return rServeConfiguration;
    }
}
