package com.github.diskursmonger.domain.classification;

import java.util.regex.Pattern;

public class OutputTypeClassifier {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[+-]?\\d+$");
    private static final Pattern FLOAT_PATTERN = Pattern.compile("^[+-]?\\d*\\.?\\d+([eE][+-]?\\d+)?$");

    public static OutputType classify(String line) {
        if (INTEGER_PATTERN.matcher(line).matches()) {
            return OutputType.INTEGER;
        }
        if (FLOAT_PATTERN.matcher(line).matches()) {
            return OutputType.FLOAT;
        }
        return OutputType.STRING;
    }
}
