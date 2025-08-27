package com.github.diskursmonger.domain;

import java.nio.file.Path;
import java.util.List;

public record AppConfig(Path outputPath, Path integers, Path floats, Path strings, String prefix,
                        boolean append, StatisticsMode statisticsMode, List<Path> inputFiles) {
    public AppConfig(Path outputPath, Path integers, Path floats, Path strings, String prefix,
                     boolean append, StatisticsMode statisticsMode, List<Path> inputFiles) {
        this.outputPath = outputPath;
        this.integers = integers;
        this.floats = floats;
        this.strings = strings;
        this.prefix = prefix;
        this.append = append;
        this.statisticsMode = statisticsMode;
        this.inputFiles = List.copyOf(inputFiles);
    }
}
