package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.AppConfig;
import com.github.diskursmonger.domain.config.OutputPaths;
import com.github.diskursmonger.domain.exception.ValidationException;

public class IOConflictValidator implements Validator {

    @Override
    public void validate(AppConfig appConfig) {
        var inputFiles = appConfig.inputFiles();

        for (var inputFile : inputFiles) {
            if (inputFile.equals(OutputPaths.getPathIntegers()) ||
                    inputFile.equals(OutputPaths.getPathFloats()) ||
                    inputFile.equals(OutputPaths.getPathStrings())
            ) {
                throw new ValidationException("Input file and output file are the same: " + inputFile);
            }
        }
    }
}
