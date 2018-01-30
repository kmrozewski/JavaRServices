package com.javar.scoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Timing {

    @JsonProperty
    private String name;

    @JsonProperty
    private String startedAt;

    @JsonProperty
    private String finishedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }
}
