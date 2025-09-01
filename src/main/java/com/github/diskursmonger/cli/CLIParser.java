package com.github.diskursmonger.cli;

import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.config.StatisticsMode;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ArgGroup;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "util", mixinStandardHelpOptions = true)
public final class CLIParser {
    @Option(names = "-o", description = "Output path")
    Path outputPath;

    @Option(names = "-p", description = "Prefix for output files")
    String prefix;

    @Option(names = "-a", description = "Append to existing output files")
    boolean append;

    @ArgGroup
    StatisticsFlags statisticsFlags;

    static class StatisticsFlags {
        @Option(names = "-s", description = "Show short statistics")
        boolean shortStatistics;
        @Option(names = "-f", description = "Show full statistics")
        boolean fullStatistics;
    }

    @Parameters(arity = "1..*", description = "Input files")
    List<Path> inputFiles;

    public AppConfig toConfig() {
        var path = (outputPath != null) ? outputPath : Path.of(System.getProperty("user.dir")).toAbsolutePath().normalize();
        var pref = (prefix != null) ? prefix : "";

        var inputFilesNormalized = new ArrayList<Path>();
        for (var inputFile : inputFiles) {
            inputFilesNormalized.add(inputFile.toAbsolutePath().normalize());
        }

        StatisticsMode statisticsMode = statisticsFlags == null ? StatisticsMode.NONE :
                statisticsFlags.shortStatistics ? StatisticsMode.SHORT : StatisticsMode.FULL;

        return new AppConfig(
                path,
                pref,
                append,
                statisticsMode,
                inputFilesNormalized
        );
    }
}
