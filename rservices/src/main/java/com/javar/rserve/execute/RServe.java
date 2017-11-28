package com.javar.rserve.execute;

import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.javar.configuration.RApplicationConfiguration;
import com.javar.configuration.RServeConfiguration;
import com.javar.configuration.RServeCredentialsConfiguration;
import com.javar.rserve.lambda.CheckedLambda;

public class RServe implements Execute {

    private RConnection connection = null;
    private RServeConfiguration configuration;
    private RServeCredentialsConfiguration credentialsConfiguration;

    @Inject
    public RServe(RApplicationConfiguration configuration) {
        this.configuration = configuration.getrServeConfiguration();
        this.credentialsConfiguration = this.configuration.getCredentialsConfiguration();
    }

    protected final void initializeConnection() throws RserveException {
        connection = new RConnection(configuration.getHost(), configuration.getPort());
    }

    @Override
    public <T> T execute(CheckedLambda<T> evalFunction, String rScript) {
        try {
            initializeConnection();

            if (connection.needLogin()) {
                authenticate();
            }

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

    private void authenticate() {
        try {
            connection.login(credentialsConfiguration.getLogin(), credentialsConfiguration.getPassword());
        } catch (RserveException e) {
            throw new WebApplicationException(UNAUTHORIZED);
        }
    }
}
