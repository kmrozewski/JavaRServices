package com.javar.rserve.execute;

import javax.inject.Inject;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.javar.configuration.RApplicationConfiguration;
import com.javar.configuration.RServeConfiguration;
import com.javar.rserve.lambda.CheckedLambda;

public class RServe implements Execute {

    private RConnection connection = null;
    private RServeConfiguration configuration;

    @Inject
    public RServe(RApplicationConfiguration configuration) {
        this.configuration = configuration.getrServeConfiguration();
    }

    protected final void initializeConnection() {
        try {
            connection = new RConnection(configuration.getHost(), configuration.getPort());
            //TODO: authentication
        } catch (RserveException e) {
            throw new RuntimeException("Failed to initialize RServe connection", e);
        }
    }

    @Override
    public <T> T execute(CheckedLambda<T> evalFunction, String rScript) {
        try {
            initializeConnection();

            return evalFunction.apply(connection, rScript);
        } catch (RserveException | REXPMismatchException e) {
            throw new RuntimeException("Error during script execution", e);
        } catch (REngineException e) {
            throw new RuntimeException("Error during script execution", e);
        } finally {
            closeConnection();
        }
    }

    protected final void closeConnection() {
        connection.close();
    }
}
