package com.github.diskursmonger.domain;

import java.nio.file.Path;
import java.util.List;

public record AppConfig(Path outputPath, String prefix, boolean append, boolean shortStatistics, boolean fullStatistics,
                        List<Path> inputFiles) {
    public AppConfig(Path outputPath, String prefix, boolean append, boolean shortStatistics, boolean fullStatistics, List<Path> inputFiles) {
        this.outputPath = outputPath;
        this.prefix = prefix;
        this.append = append;
        this.shortStatistics = shortStatistics;
        this.fullStatistics = fullStatistics;
        this.inputFiles = List.copyOf(inputFiles);
    }
}
