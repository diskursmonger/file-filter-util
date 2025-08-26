package com.github.diskursmonger.domain.config;

import com.github.diskursmonger.domain.AppConfig;

import java.nio.file.Path;

public class OutputPaths {
    private static Path integers;
    private static Path floats;
    private static Path strings;

    public static Path getPathIntegers() {
        return integers;
    }

    public static Path getPathFloats() {
        return floats;
    }

    public static Path getPathStrings() {
        return strings;
    }

    public static void setOutputFiles(AppConfig appConfig) {
        var outputPath = appConfig.outputPath();
        var prefix = appConfig.prefix();
        integers = outputPath.resolve(prefix + "integers.txt");
        floats = outputPath.resolve(prefix + "floats.txt");
        strings = outputPath.resolve(prefix + "strings.txt");
    }
}
