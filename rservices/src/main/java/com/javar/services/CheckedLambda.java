package com.javar.services;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;

@FunctionalInterface
public interface CheckedLambda<T> {
    T apply(String script) throws RserveException, REXPMismatchException;
}
