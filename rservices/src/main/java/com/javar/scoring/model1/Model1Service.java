package com.javar.scoring.model1;

import static com.javar.util.REXPParser.getREXP;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.scoring.services.ScoringService;

public class Model1Service extends ScoringService<Model1DataFrame> {

    private static final String R_SCRIPT_PATH = "rScripts/model1_predict.R";
    private final String rScript = read(this.getClass(), R_SCRIPT_PATH);
    private final ObjectMapper mapper = new ObjectMapper();

    @Inject
    public Model1Service(RServe rServe) {
        super(rServe);
    }

    @Override
    protected ImmutableMap<String, Object> getModelDataFrameMappings(Model1DataFrame modelDataFrame) {
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
            .build();
    }

    public Model1Response predict(Model1DataFrame modelDataFrame) {
        try {
            String results = run(modelDataFrame, rScript);
            logger.info("Model1 response from R: \n{}", results);
            Model1Response response = mapper.readValue(results, Model1Response.class).setId(modelDataFrame.getId());
            response.getInputData().setId(modelDataFrame.getId());

            return response;
        } catch (IOException e) {
            throw new RuntimeException("Unable to map R script response to Model1Response", e);
        }
    }
}
