package com.javar.scoring.model4;

import static com.javar.scoring.model4.Model4Mappings.getMappings;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.scoring.services.ScoringService;

public class Model4Service extends ScoringService<Model4DataFrame> {

    private static final String R_SCRIPT_PATH = "rScripts/model4_predict.R";
    private final String rScript = read(this.getClass(), R_SCRIPT_PATH);

    @Inject
    public Model4Service(RServe rServe) {
        super(rServe);
    }

    @Override
    protected ImmutableMap<String, Object> getModelDataFrameMappings(Model4DataFrame modelDataFrame) {
        return getMappings(modelDataFrame);
    }

    public Model4Response predict(Model4DataFrame modelDataFrame) {
        try {
            String results = run(modelDataFrame, rScript);
            logger.info("Model4 response from R: \n{}", results);
            Model4Response response = mapper.readValue(results, Model4Response.class).setId(modelDataFrame.getId());
            response.getInputData().setId(modelDataFrame.getId());

            return response;
        } catch (IOException e) {
            throw new RuntimeException("Unable to map R script response to Model1Response", e);
        }
    }
}
