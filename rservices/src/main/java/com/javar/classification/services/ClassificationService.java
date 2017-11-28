package com.javar.classification.services;

import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javar.classification.models.IrisDataFrame;
import com.javar.classification.models.RandomForestResponse;
import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;

public class ClassificationService {

    private static final String R_SCRIPT_PATH = "rScripts/random_forest_model.R";
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
            connection.assign(COL_1, new double[] { dataFrame.getSepalLength() });
            connection.assign(COL_2, new double[] { dataFrame.getSepalWidth() });
            connection.assign(COL_3, new String[] { dataFrame.getPetalLength() });
            connection.assign(COL_4, new String[] { dataFrame.getPetalWidth() });

            return connection.eval(script).asString();
        };
    }
}
