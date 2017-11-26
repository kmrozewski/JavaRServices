package com.javar.rserve.execute;

import com.javar.rserve.lambda.CheckedLambda;

public interface Execute {
    <T> T execute(CheckedLambda<T> evalFunction, String rScript);
}
