package com.javar.scoring.model3;

import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ModelDataFrame;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model3DataFrame extends ModelDataFrame {

    @NotNull
    @JsonProperty("X01")
    private int inputVariable01;

    @NotNull
    @JsonProperty("X02")
    private String inputVariable02;

    @NotNull
    @JsonProperty("X03")
    private int inputVariable03;

    @NotNull
    @JsonProperty("X04")
    private int inputVariable04;

    @NotNull
    @JsonProperty("X05")
    private double inputVariable05;

    @NotNull
    @JsonProperty("X06")
    private String inputVariable06;

    @NotNull
    @JsonProperty("X07")
    private int inputVariable07;

    @NotNull
    @JsonProperty("X08")
    private int inputVariable08;

    @NotNull
    @JsonProperty("X09")
    private int inputVariable09;

    @NotNull
    @JsonProperty("X10")
    private int inputVariable10;

    @NotNull
    @JsonProperty("X11")
    private int inputVariable11;

    @NotNull
    @JsonProperty("X12")
    private int inputVariable12;

    @NotNull
    @JsonProperty("X13")
    private int inputVariable13;

    @NotNull
    @JsonProperty("X14")
    private int inputVariable14;

    @NotNull
    @JsonProperty("X15")
    private double inputVariable15;

    @NotNull
    @JsonProperty("X16")
    private int inputVariable16;

    @NotNull
    @JsonProperty("X17")
    private int inputVariable17;

    @NotNull
    @JsonProperty("X18")
    private int inputVariable18;

    @NotNull
    @JsonProperty("X19")
    private int inputVariable19;

    @NotNull
    @JsonProperty("X20")
    private int inputVariable20;

    @NotNull
    @JsonProperty("X21")
    private int inputVariable21;

    @NotNull
    @JsonProperty("X22")
    private int inputVariable22;

    @NotNull
    @JsonProperty("X23")
    private int inputVariable23;

    @NotNull
    @JsonProperty("X24")
    private int inputVariable24;

    @NotNull
    @JsonProperty("X25")
    private int inputVariable25;

    @NotNull
    @JsonProperty("X26")
    private int inputVariable26;

    @NotNull
    @JsonProperty("X27")
    private int inputVariable27;

    @NotNull
    @JsonProperty("X28")
    private int inputVariable28;

    @NotNull
    @JsonProperty("X29")
    private int inputVariable29;

    @NotNull
    @JsonProperty("X30")
    private int inputVariable30;

    @NotNull
    @JsonProperty("X31")
    private int inputVariable31;

    @NotNull
    @JsonProperty("X32")
    private int inputVariable32;

    @NotNull
    @JsonProperty("X33")
    private double inputVariable33;

    @NotNull
    @JsonProperty("X34")
    private double inputVariable34;

    @NotNull
    @JsonProperty("X35")
    private int inputVariable35;

    @NotNull
    @JsonProperty("X36")
    private int inputVariable36;

    @NotNull
    @JsonProperty("X37")
    private int inputVariable37;

    @NotNull
    @JsonProperty("X38")
    private double inputVariable38;

    @NotNull
    @JsonProperty("X39")
    private double inputVariable39;

    @NotNull
    @JsonProperty("X40")
    private double inputVariable40;

    @NotNull
    @JsonProperty("X41")
    private int inputVariable41;

    @NotNull
    @JsonProperty("X42")
    private int inputVariable42;

    @NotNull
    @JsonProperty("X43")
    private int inputVariable43;

    @NotNull
    @JsonProperty("X44")
    private int inputVariable44;

    @NotNull
    @JsonProperty("X45")
    private double inputVariable45;

    @NotNull
    @JsonProperty("X46")
    private double inputVariable46;

    @NotNull
    @JsonProperty("X47")
    private int inputVariable47;

    @NotNull
    @JsonProperty("X48")
    private int inputVariable48;
}
