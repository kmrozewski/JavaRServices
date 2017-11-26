package com.javar.util;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public final class ScriptReader {


    private ScriptReader() {}

    public static String read(Class className, String fileName) {
        try {
            return IOUtils.toString(className.getClassLoader().getResourceAsStream(fileName), "UTF8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
