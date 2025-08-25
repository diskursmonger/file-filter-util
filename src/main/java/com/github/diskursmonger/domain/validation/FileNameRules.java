package com.github.diskursmonger.domain.validation;

import java.util.List;
import java.util.regex.Pattern;

public final class FileNameRules {
    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("win");
    private static final Pattern ILLEGAL_WIN = Pattern.compile("\\\\/:*?\"<>|");
    private static final Pattern ILLEGAL_UNIX = Pattern.compile("/");
    private static final List<String> RESERVED_WIN = List.of(
            "CON", "PRN", "AUX", "NUL",
            "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
            "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"
    );

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    public static Pattern illegalCharsPattern() {
        return IS_WINDOWS ? ILLEGAL_WIN : ILLEGAL_UNIX;
    }

    public static boolean isReservedName(String name) {
        return IS_WINDOWS && RESERVED_WIN.contains(name.toUpperCase());
    }
}
