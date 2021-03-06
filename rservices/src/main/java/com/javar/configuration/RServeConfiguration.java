package com.javar.configuration;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RServeConfiguration {

    @NotNull
    @JsonProperty
    private String host;

    @NotNull
    @JsonProperty
    private int port;

    @JsonProperty("credentials")
    private RServeCredentialsConfiguration credentialsConfiguration;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public RServeCredentialsConfiguration getCredentialsConfiguration() {
        return credentialsConfiguration;
    }
}
