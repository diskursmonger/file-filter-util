package com.github.diskursmonger.service;

import com.github.diskursmonger.cli.CLIParser;
import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;
import com.github.diskursmonger.domain.validation.ValidatorFactory;
import picocli.CommandLine;

public class ApplicationService {
    public static void execute(String[] args) {
        var cliParser = new CLIParser();
        var cmd = new CommandLine(cliParser);

        try {
            cmd.parseArgs(args);
            AppConfig appConfig = cliParser.toConfig();
            var validatorFactory = new ValidatorFactory();
            var validatorService = new ValidatorService(validatorFactory.create());
            validatorService.validate(appConfig);
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
