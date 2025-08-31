package com.github.diskursmonger.app;

import com.github.diskursmonger.cli.CLIParser;
import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;
import com.github.diskursmonger.domain.validation.ValidatorFactory;
import com.github.diskursmonger.filtering.FileFilterService;
import picocli.CommandLine;

import java.io.IOException;

public class ApplicationService {
    public static void execute(String[] args) {
        var cliParser = new CLIParser();
        var cmd = new CommandLine(cliParser);

        try {
            cmd.parseArgs(args);
            AppConfig appConfig = cliParser.toConfig();
            var validatorService = new ValidatorService(ValidatorFactory.create());
            validatorService.validate(appConfig);
            var fileFilterService = new FileFilterService();
            fileFilterService.run(appConfig);
        } catch (CommandLine.ParameterException e) {
            System.err.println("Arguments error: " + e.getMessage());
            System.exit(2);
        } catch (ValidationException e) {
            System.err.println("Arguments error: " + e.getMessage());
            System.exit(3);
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            System.exit(4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
