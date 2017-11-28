package com.javar.classification.services;

import static com.javar.util.REXPParser.getREXP;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.javar.classification.models.IrisDataFrame;
import com.javar.classification.models.RandomForestResponse;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;

public class ClassificationService {

    private static final String R_SCRIPT_PATH = "rScripts/random_forest_model.R";
    private static final String INPUT_DATA_NAME = "frm";
    private static final String COL_1 = "sepalLength";
    private static final String COL_2 = "sepalWidth";
    private static final String COL_3 = "petalLength";
    private static final String COL_4 = "petalWidth";

    private final ObjectMapper mapper = new ObjectMapper();

    private RServe rServe;

    @Inject
    public ClassificationService(RServe rServe) {
        this.rServe = rServe;
    }

    public RandomForestResponse predict(IrisDataFrame irisDataFrame) {
        try {
            String rScript = read(this.getClass(), R_SCRIPT_PATH);
            String result = rServe.execute(evaluate(irisDataFrame), rScript);

            return mapper.readValue(result, RandomForestResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to map response to RandomForestResponse.class", e);
        }
    }

    private CheckedLambda<String> evaluate(IrisDataFrame dataFrame) {
        return (connection, script) -> {
            //TODO: handle null values
            connection.assign(INPUT_DATA_NAME, createDataFrame(dataFrame));

            return connection.eval(script).asString();
        };
    }

    private REXP createDataFrame(IrisDataFrame dataFrame) throws REXPMismatchException {
        ImmutableMap<String, Object> map = ImmutableMap.<String, Object>builder()
            .put(COL_1, getREXP(dataFrame::getSepalLength))
            .put(COL_2, getREXP(dataFrame::getSepalWidth))
            .put(COL_3, getREXP(dataFrame::getPetalLength))
            .put(COL_4, getREXP(dataFrame::getPetalWidth))
            .build();

        RList list = new RList();
        list.putAll(map);

        return REXP.createDataFrame(list);
    }
}
