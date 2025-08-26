package com.github.diskursmonger.cli;

import com.github.diskursmonger.domain.AppConfig;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

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

    @Option(names = "-s", description = "Show short statistics")
    boolean shortStatistics;

    @Option(names = "-f", description = "Show full statistics")
    boolean fullStatistics;

    @Parameters(arity = "1..*", description = "Input files")
    List<Path> inputFiles;

    public AppConfig toConfig() {
        var path = (outputPath != null) ? outputPath : Path.of(System.getProperty("user.dir"));
        var pref = (prefix != null) ? prefix : "";

        var inputFilesNormalized = new ArrayList<Path>();
        for (var inputFile : inputFiles) {
            inputFilesNormalized.add(inputFile.toAbsolutePath().normalize());
        }

        return new AppConfig(
                path.toAbsolutePath().normalize(),
                pref,
                append,
                shortStatistics,
                fullStatistics,
                inputFilesNormalized
        );
    }
}
