package com.github.diskursmonger.filtering.exception;

import java.io.IOException;

public class FileOperationException extends IOException {
    public FileOperationException(String message) {
        super(message);
    }
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
