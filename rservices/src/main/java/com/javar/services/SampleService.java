package com.javar.services;

import javax.inject.Inject;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.javar.configuration.RApplicationConfiguration;
import com.javar.configuration.RServeConfiguration;

public class SampleService {

    private RConnection connection = null;
    private RServeConfiguration configuration;

    @Inject
    public SampleService(RApplicationConfiguration configuration) {
        this.configuration = configuration.getrServeConfiguration();
    }

    public void initialize() {
        try {
            connection = new RConnection(configuration.getHost(), configuration.getPort());
        } catch (RserveException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getSum(int a, int b) {
        try {
            return connection.eval(String.format("%s + %s", a, b)).asInteger();
        } catch (RserveException e) {
            throw new RuntimeException(e);
        } catch (REXPMismatchException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
