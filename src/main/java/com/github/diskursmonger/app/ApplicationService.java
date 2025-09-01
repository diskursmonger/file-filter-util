package com.github.diskursmonger.app;

import com.github.diskursmonger.cli.CLIParser;
import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;
import com.github.diskursmonger.domain.validation.ValidatorFactory;
import com.github.diskursmonger.filtering.FileFilterService;
import com.github.diskursmonger.filtering.exception.FileOperationException;
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
            System.err.println("Impossible to continue: arguments error. " + e.getMessage());
            System.exit(2);
        } catch (ValidationException e) {
            System.err.println("Impossible to continue: arguments error. " + e.getMessage());
            System.exit(3);
        } catch (OutOfMemoryError e) {
            System.err.println("Impossible to continue: Out of memory error. " + e.getMessage());
            System.exit(4);
        } catch (FileOperationException e) {
            System.err.println("Impossible to continue: I/O error. " + e.getMessage());
            System.exit(5);
        } catch (IOException e) {
            System.err.println("Impossible to continue: I/O error. " + e.getMessage());
            System.exit(6);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
