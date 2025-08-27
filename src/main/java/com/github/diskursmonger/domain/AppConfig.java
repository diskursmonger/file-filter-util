package com.github.diskursmonger.domain;

import java.nio.file.Path;
import java.util.List;

public record AppConfig(Path outputPath, String prefix, boolean append, StatisticsMode statisticsMode,
                        List<Path> inputFiles, Path integers, Path floats, Path strings) {
    private static final Path INTEGERS_DEFAULT_PATH_NAME = Path.of("integers.txt");
    private static final Path FLOATS_DEFAULT_PATH_NAME = Path.of("floats.txt");
    private static final Path STRINGS_DEFAULT_PATH_NAME = Path.of("strings.txt");
    public AppConfig {
        integers = outputPath.resolve(prefix + INTEGERS_DEFAULT_PATH_NAME);
        floats = outputPath.resolve(prefix + FLOATS_DEFAULT_PATH_NAME);
        strings = outputPath.resolve(prefix + STRINGS_DEFAULT_PATH_NAME);
    }
    public AppConfig(Path outputPath, String prefix, boolean append, StatisticsMode statisticsMode, List<Path> inputFiles) {
        this(outputPath, prefix, append, statisticsMode, inputFiles,
                null, null, null);
    }
}
