package com.github.diskursmonger;

import com.github.diskursmonger.cli.CLIParser;
import com.github.diskursmonger.domain.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;
import com.github.diskursmonger.domain.validate.AppConfigValidator;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        CLIParser cliParser = new CLIParser();
        CommandLine cmd = new CommandLine(cliParser);

        try {
            cmd.parseArgs(args);
            AppConfig config = cliParser.toConfig();
            AppConfigValidator.validate(config);
        } catch (CommandLine.ParameterException e) {
            System.err.println("Arguments error: " + e.getMessage());
            System.exit(2);
        } catch (ValidationException e) {
            System.err.println("Arguments error: " + e.getMessage());
            System.exit(3);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}