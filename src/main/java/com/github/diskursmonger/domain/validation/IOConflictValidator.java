package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;

public class IOConflictValidator implements Validator {

    @Override
    public void validate(AppConfig appConfig) {
        var inputFiles = appConfig.inputFiles();

        for (var inputFile : inputFiles) {
            if (inputFile.equals(appConfig.integers()) ||
                    inputFile.equals(appConfig.floats()) ||
                    inputFile.equals(appConfig.strings())
            ) {
                throw new ValidationException("Input file and output file are the same: " + inputFile);
            }
        }
    }
}
