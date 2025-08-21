package com.github.diskursmonger.domain.validate;

import com.github.diskursmonger.domain.exception.ValidationException;

import java.nio.file.Files;
import java.nio.file.Path;

public class OutputPathValidator {

    public static void validate(Path outputPath) {
        Path simplified = outputPath.normalize();
        validatePathNames(simplified);
        if (Files.exists(simplified)) {
            if (!Files.isDirectory(simplified)) {
                throw new ValidationException("Output path points to a file: " + outputPath);
            }
            if (!Files.isWritable(simplified)) {
                throw new ValidationException("Output directory is not writable: " + outputPath);
            }
            return;
        }

        Path existing = simplified.getParent();
        if (existing == null) {
            existing = Path.of(System.getProperty("user.dir"));
        }

        boolean found = false;

        while (existing != null && !found) {
            if (Files.exists(existing)) {
                found = true;
            } else {
                existing = existing.getParent();
            }
        }

        if (!found) {
            throw new ValidationException("No parent.");
        } else {
            if (!Files.isDirectory(existing)) {
                throw new ValidationException("No existing parent directory.");
            }
            if (!Files.isWritable(existing)) {
                throw new ValidationException("Parent directory is not writable.");
            }
        }
    }

    private static void validatePathNames(Path path) {
        for (Path folder : path) {
            String name = folder.toString();
            validateFolderName(name);
        }
    }

    private static void validateFolderName(String name) {
        if (FileNameRules.isWindows()) {
            if (FileNameRules.illegalCharsPattern().matcher(name).find()) {
                throw new ValidationException("Invalid folder name.");
            }
            if (name.endsWith(" ") || name.endsWith(".")) {
                throw new ValidationException("Invalid folder name.");
            }
            if (FileNameRules.isReservedName(name.toUpperCase())) {
                throw new ValidationException("Invalid folder name.");
            }
        } else {
            if (FileNameRules.illegalCharsPattern().matcher(name).find()) {
                throw new ValidationException("Invalid folder name.");
            }
        }

        if (name.length() > 255) {
            throw new ValidationException("Output folder name too long.");
        }
    }
}
