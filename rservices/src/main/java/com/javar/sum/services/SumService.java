package com.javar.sum.services;

import javax.inject.Inject;

import com.javar.rserve.execute.RServe;
import com.javar.rserve.lambda.CheckedLambda;
import com.javar.util.ScriptReader;

public class SumService {

    private static final String R_SCRIPT_PATH = "rScripts/sum.R";

    private RServe RServe;

    @Inject
    public SumService(RServe RServe) {
        this.RServe = RServe;
    }

    public Integer calculateSum(double x, double y) {
        return RServe.execute(evaluate(x, y), ScriptReader.read(this.getClass(), R_SCRIPT_PATH));
    }

    private CheckedLambda<Integer> evaluate(double x, double y) {
        return (connection, script) -> {
            connection.assign("x", new double[] { x });
            connection.assign("y", new double[] { y });

            return connection.eval(script).asInteger();
        };
    }
}
