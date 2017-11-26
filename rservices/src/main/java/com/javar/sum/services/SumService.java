package com.javar.sum.services;

import javax.inject.Inject;

import com.javar.rserve.execute.RServe;

public class SumService {

    private RServe RServe;

    @Inject
    public SumService(RServe RServe) {
        this.RServe = RServe;
    }

    public Integer calculateSum(int x, int y) {
        String script = String.format("%s + %s", x, y);

        return RServe.execute(((conn, s) -> conn.eval(s).asInteger()), script);
    }
}
