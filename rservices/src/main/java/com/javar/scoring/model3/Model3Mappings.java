package com.javar.scoring.model3;

import static com.javar.util.REXPParser.getREXP;

import com.google.common.collect.ImmutableMap;

final class Model3Mappings {

    private Model3Mappings() {
    }

    static ImmutableMap<String, Object> getMappings(Model3DataFrame modelDataFrame) {
        return ImmutableMap.<String, Object>builder()
            .put("X01", getREXP(modelDataFrame::getInputVariable01))
            .put("X02", getREXP(modelDataFrame::getInputVariable02))
            .put("X03", getREXP(modelDataFrame::getInputVariable03))
            .put("X04", getREXP(modelDataFrame::getInputVariable04))
            .put("X05", getREXP(modelDataFrame::getInputVariable05))
            .put("X06", getREXP(modelDataFrame::getInputVariable06))
            .put("X07", getREXP(modelDataFrame::getInputVariable07))
            .put("X08", getREXP(modelDataFrame::getInputVariable08))
            .put("X09", getREXP(modelDataFrame::getInputVariable09))
            .put("X10", getREXP(modelDataFrame::getInputVariable10))
            .put("X11", getREXP(modelDataFrame::getInputVariable11))
            .put("X12", getREXP(modelDataFrame::getInputVariable12))
            .put("X13", getREXP(modelDataFrame::getInputVariable13))
            .put("X14", getREXP(modelDataFrame::getInputVariable14))
            .put("X15", getREXP(modelDataFrame::getInputVariable15))
            .put("X16", getREXP(modelDataFrame::getInputVariable16))
            .put("X17", getREXP(modelDataFrame::getInputVariable17))
            .put("X18", getREXP(modelDataFrame::getInputVariable18))
            .put("X19", getREXP(modelDataFrame::getInputVariable19))
            .put("X20", getREXP(modelDataFrame::getInputVariable20))
            .put("X21", getREXP(modelDataFrame::getInputVariable21))
            .put("X22", getREXP(modelDataFrame::getInputVariable22))
            .put("X23", getREXP(modelDataFrame::getInputVariable23))
            .put("X24", getREXP(modelDataFrame::getInputVariable24))
            .put("X25", getREXP(modelDataFrame::getInputVariable25))
            .put("X26", getREXP(modelDataFrame::getInputVariable26))
            .put("X27", getREXP(modelDataFrame::getInputVariable27))
            .put("X28", getREXP(modelDataFrame::getInputVariable28))
            .put("X29", getREXP(modelDataFrame::getInputVariable29))
            .put("X30", getREXP(modelDataFrame::getInputVariable30))
            .put("X31", getREXP(modelDataFrame::getInputVariable31))
            .put("X32", getREXP(modelDataFrame::getInputVariable32))
            .put("X33", getREXP(modelDataFrame::getInputVariable33))
            .put("X34", getREXP(modelDataFrame::getInputVariable34))
            .put("X35", getREXP(modelDataFrame::getInputVariable35))
            .put("X36", getREXP(modelDataFrame::getInputVariable36))
            .put("X37", getREXP(modelDataFrame::getInputVariable37))
            .put("X38", getREXP(modelDataFrame::getInputVariable38))
            .put("X39", getREXP(modelDataFrame::getInputVariable39))
            .put("X40", getREXP(modelDataFrame::getInputVariable40))
            .put("X41", getREXP(modelDataFrame::getInputVariable41))
            .put("X42", getREXP(modelDataFrame::getInputVariable42))
            .put("X43", getREXP(modelDataFrame::getInputVariable43))
            .put("X44", getREXP(modelDataFrame::getInputVariable44))
            .put("X45", getREXP(modelDataFrame::getInputVariable45))
            .put("X46", getREXP(modelDataFrame::getInputVariable46))
            .put("X47", getREXP(modelDataFrame::getInputVariable47))
            .put("X48", getREXP(modelDataFrame::getInputVariable48))
            .build();
    }
}
