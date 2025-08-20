package com.github.diskursmonger;
import com.github.diskursmonger.cli.CLIParser;
import com.github.diskursmonger.domain.AppConfig;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        CLIParser cliParser = new CLIParser();
        CommandLine cmd = new CommandLine(cliParser);

        try {
            cmd.parseArgs(args);
            AppConfig config = cliParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}