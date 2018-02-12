package com.javar.scoring.model2;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javar.scoring.models.ModelDataFrame;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model2DataFrame extends ModelDataFrame {

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
    private String inputVariable07;

    @NotNull
    @JsonProperty("X08")
    private double inputVariable08;

    @NotNull
    @JsonProperty("X09")
    private int inputVariable09;

    @NotNull
    @JsonProperty("X10")
    private double inputVariable10;

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
    private int inputVariable15;

    @NotNull
    @JsonProperty("X16")
    private int inputVariable16;

    @NotNull
    @JsonProperty("X17")
    private int inputVariable17;

    public int getInputVariable01() {
        return inputVariable01;
    }

    public void setInputVariable01(int inputVariable01) {
        this.inputVariable01 = inputVariable01;
    }

    public String getInputVariable02() {
        return inputVariable02;
    }

    public void setInputVariable02(String inputVariable02) {
        this.inputVariable02 = inputVariable02;
    }

    public int getInputVariable03() {
        return inputVariable03;
    }

    public void setInputVariable03(int inputVariable03) {
        this.inputVariable03 = inputVariable03;
    }

    public int getInputVariable04() {
        return inputVariable04;
    }

    public void setInputVariable04(int inputVariable04) {
        this.inputVariable04 = inputVariable04;
    }

    public double getInputVariable05() {
        return inputVariable05;
    }

    public void setInputVariable05(double inputVariable05) {
        this.inputVariable05 = inputVariable05;
    }

    public String getInputVariable06() {
        return inputVariable06;
    }

    public void setInputVariable06(String inputVariable06) {
        this.inputVariable06 = inputVariable06;
    }

    public String getInputVariable07() {
        return inputVariable07;
    }

    public void setInputVariable07(String inputVariable07) {
        this.inputVariable07 = inputVariable07;
    }

    public double getInputVariable08() {
        return inputVariable08;
    }

    public void setInputVariable08(double inputVariable08) {
        this.inputVariable08 = inputVariable08;
    }

    public int getInputVariable09() {
        return inputVariable09;
    }

    public void setInputVariable09(int inputVariable09) {
        this.inputVariable09 = inputVariable09;
    }

    public double getInputVariable10() {
        return inputVariable10;
    }

    public void setInputVariable10(double inputVariable10) {
        this.inputVariable10 = inputVariable10;
    }

    public int getInputVariable11() {
        return inputVariable11;
    }

    public void setInputVariable11(int inputVariable11) {
        this.inputVariable11 = inputVariable11;
    }

    public int getInputVariable12() {
        return inputVariable12;
    }

    public void setInputVariable12(int inputVariable12) {
        this.inputVariable12 = inputVariable12;
    }

    public int getInputVariable13() {
        return inputVariable13;
    }

    public void setInputVariable13(int inputVariable13) {
        this.inputVariable13 = inputVariable13;
    }

    public int getInputVariable14() {
        return inputVariable14;
    }

    public void setInputVariable14(int inputVariable14) {
        this.inputVariable14 = inputVariable14;
    }

    public int getInputVariable15() {
        return inputVariable15;
    }

    public void setInputVariable15(int inputVariable15) {
        this.inputVariable15 = inputVariable15;
    }

    public int getInputVariable16() {
        return inputVariable16;
    }

    public void setInputVariable16(int inputVariable16) {
        this.inputVariable16 = inputVariable16;
    }

    public int getInputVariable17() {
        return inputVariable17;
    }

    public void setInputVariable17(int inputVariable17) {
        this.inputVariable17 = inputVariable17;
    }
}
