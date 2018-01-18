package com.javar.classification.services;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import static com.javar.util.REXPParser.getREXP;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.javar.classification.models.InputData;
import com.javar.classification.models.IrisDataFrame;
import com.javar.classification.models.RandomForestResponse;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;

public class ClassificationService {

    private static final String R_SCRIPT_SINGLE_PATH = "rScripts/random_forest_predict_single.R";
    private static final String R_SCRIPT_ALL_PATH = "rScripts/random_forest_predict_all.R";
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
            String rScript = read(this.getClass(), R_SCRIPT_SINGLE_PATH);
            REXP dataFrame = createDataFrame(irisDataFrame);
            String result = rServe.execute(evaluate(dataFrame), rScript);

            return mapper.readValue(result, RandomForestResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to map response to RandomForestResponse.class", e);
        } catch (REXPMismatchException e) {
            throw new WebApplicationException("Wrong data format", BAD_REQUEST);
        }
    }

    public RandomForestResponse predictAll(List<IrisDataFrame> list) throws REXPMismatchException {
        try {
            String rScript = read(this.getClass(), R_SCRIPT_SINGLE_PATH);

            RList rlist = new RList();
            rlist.addAll(list);
            REXP frm = REXP.createDataFrame(rlist);
        } catch (IOException e) {
            throw new RuntimeException("Failed to map response to RandomForestResponse.class", e);
        }

        return null;
    }

    private CheckedLambda<String> evaluate(REXP dataFrame) {
        return (connection, script) -> {
            connection.assign(INPUT_DATA_NAME, dataFrame);

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
