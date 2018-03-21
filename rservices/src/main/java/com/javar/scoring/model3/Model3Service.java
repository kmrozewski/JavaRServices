package com.javar.scoring.model3;

import static com.javar.scoring.model3.Model3Mappings.getMappings;
import static com.javar.util.ScriptReader.read;

import java.io.IOException;

import javax.inject.Inject;

import com.google.common.collect.ImmutableMap;
import com.javar.rserve.execute.RServe;
import com.javar.scoring.services.ScoringService;

public class Model3Service extends ScoringService<Model3DataFrame> {

    private static final String R_SCRIPT_PATH = "rScripts/model3_predict.R";
    private final String rScript = read(this.getClass(), R_SCRIPT_PATH);

    @Inject
    public Model3Service(RServe rServe) {
        super(rServe);
    }

    @Override
    protected ImmutableMap<String, Object> getModelDataFrameMappings(Model3DataFrame modelDataFrame) {
        return getMappings(modelDataFrame);
    }

    public Model3Response predict(Model3DataFrame modelDataFrame) {
        try {
            String results = run(modelDataFrame, rScript);
            logger.info("Model4 response from R: \n{}", results);
            Model3Response response = mapper.readValue(results, Model3Response.class).setId(modelDataFrame.getId());
            response.getInputData().setId(modelDataFrame.getId());

            return response;
        } catch (IOException e) {
            throw new RuntimeException("Unable to map R script response to Model1Response", e);
        }
    }
}
