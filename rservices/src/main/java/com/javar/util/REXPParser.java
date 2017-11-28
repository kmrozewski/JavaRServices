package com.javar.util;

import java.util.function.Function;
import java.util.function.Supplier;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPDouble;
import org.rosuda.REngine.REXPInteger;
import org.rosuda.REngine.REXPLogical;
import org.rosuda.REngine.REXPNull;
import org.rosuda.REngine.REXPString;

import com.google.common.collect.ImmutableMap;

public final class REXPParser {

    private static final ImmutableMap<Class, Function<Object, REXP>> map = ImmutableMap.<Class, Function<Object, REXP>>builder()
        .put(String.class, object -> new REXPString((String) object))
        .put(Double.class, object -> new REXPDouble((Double) object))
        .put(Integer.class, object -> new REXPInteger((Integer) object))
        .put(Boolean.class, object -> new REXPLogical((Boolean) object))
        .build();

    private REXPParser() {
    }

    public static <T> REXP getREXP(Supplier<T> getValue) {
        T value = getValue.get();

        return map.getOrDefault(value.getClass(), object -> new REXPNull()).apply(value);
    }
}
