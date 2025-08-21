package com.github.diskursmonger.cli;

import com.github.diskursmonger.domain.AppConfig;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.List;

@CommandLine.Command(name = "util", mixinStandardHelpOptions = true)
public final class CLIParser {
    @Option(names = "-o", description = "Output path")
    Path outputPath;

    @Option(names = "-p", description = "Prefix for output files", required = true)
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
        Path path = (outputPath != null) ? outputPath : Path.of(System.getProperty("user.dir"));
        String pref = (prefix != null) ? prefix : "";
        return new AppConfig(
                path,
                pref,
                append,
                shortStatistics,
                fullStatistics,
                inputFiles
        );
    }
}
