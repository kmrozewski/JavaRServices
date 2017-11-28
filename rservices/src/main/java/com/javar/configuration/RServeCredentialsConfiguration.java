package com.javar.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RServeCredentialsConfiguration {
    @JsonProperty
    private String login;

    @JsonProperty
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
