package com.github.diskursmonger.domain.validation;

import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.exception.ValidationException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

public class InputFilesValidator implements Validator {

    @Override
    public void validate(AppConfig appConfig) {
        var inputFiles = List.copyOf(appConfig.inputFiles());
        var uniquePaths = new HashSet<Path>();

        for (var inputFile : inputFiles) {
            if (!Files.exists(inputFile)) {
                throw new ValidationException("Input file doesn't exist: " + inputFile);
            }
            if (!Files.isReadable(inputFile)) {
                throw new ValidationException("Can't read file: " + inputFile);
            }
            if (Files.isDirectory(inputFile)) {
                throw new ValidationException("File is a directory: " + inputFile);
            }
            if (uniquePaths.contains(inputFile)) {
                throw new ValidationException("Duplicate input file: " + inputFile);
            }
            uniquePaths.add(inputFile);
        }
    }
}
