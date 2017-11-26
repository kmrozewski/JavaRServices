package com.javar.rserve.lambda;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

@FunctionalInterface
public interface CheckedLambda<R> {
    R apply(RConnection rConnection, String rScript) throws RserveException, REXPMismatchException;
}
