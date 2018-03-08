package com.javar.scoring.model5;

import static com.javar.scoring.model5.Model5Mappings.getMappings;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.javar.rserve.execute.RServe;
import com.javar.scoring.services.ScoringService;

public class Model5Service extends ScoringService<Model5DataFrame> {

    private static final String R_SCRIPT_PATH = "rScripts/model5_predict.R";
    private final String rScript = read(this.getClass(), R_SCRIPT_PATH);

    @Inject
    public Model5Service(RServe rServe) {
        super(rServe);
    }

    @Override
    protected ImmutableMap<String, Object> getModelDataFrameMappings(Model5DataFrame modelDataFrame) {
        return getMappings(modelDataFrame);
    }

    public Model5Response predict(Model5DataFrame modelDataFrame) {
        try {
            String results = run(modelDataFrame, rScript);
            logger.info("Model4 response from R: \n{}", results);
            Model5Response response = mapper.readValue(results, Model5Response.class).setId(modelDataFrame.getId());
            response.getInputData().setId(modelDataFrame.getId());

            return response;
        } catch (IOException e) {
            throw new RuntimeException("Unable to map R script response to Model1Response", e);
        }
    }
}
