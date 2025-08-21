package com.github.diskursmonger.domain.validate;

import com.github.diskursmonger.domain.exception.ValidationException;

import java.util.regex.Pattern;

public class PrefixValidator {
    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("win");
    private static final Pattern ILLEGAL_WIN = Pattern.compile("\\\\/:*?\"<>|");
    private static final Pattern ILLEGAL_UNIX = Pattern.compile("/");

    private PrefixValidator() {}
    public static void validate(String prefix) {
        var pattern = IS_WINDOWS ? ILLEGAL_WIN : ILLEGAL_UNIX;
        if (pattern.matcher(prefix).find()) {
            throw new ValidationException("Prefix contains illegal characters for this OS.");
        }
    }
}
