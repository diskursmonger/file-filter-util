package com.github.diskursmonger.filtering.io;

import com.github.diskursmonger.domain.classification.OutputType;
import com.github.diskursmonger.domain.config.AppConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputManager implements AutoCloseable {
    private final boolean append;
    private final Path integers;
    private final Path floats;
    private final Path strings;
    private BufferedWriter integersWriter;
    private BufferedWriter floatsWriter;
    private BufferedWriter stringsWriter;


    public OutputManager(AppConfig appConfig) {
        this.append = appConfig.append();
        this.integers = appConfig.integers();
        this.floats = appConfig.floats();
        this.strings = appConfig.strings();
    }

    public void write(String line, OutputType type) throws IOException {
        var writer = getWriter(type);
        writer.write(line);
        writer.newLine();
    }

    private BufferedWriter getWriter(OutputType type) throws IOException {
        return switch (type) {
            case INTEGER -> getIntegersWriter();
            case FLOAT   -> getFloatsWriter();
            case STRING  -> getStringsWriter();
        };
    }

    private BufferedWriter openWriter(Path path) throws IOException {
        Path parent = path.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        return new BufferedWriter(new FileWriter(path.toFile(), append));
    }

    private BufferedWriter getIntegersWriter() throws IOException {
        if (integersWriter == null) {
            integersWriter = openWriter(integers);
        }
        return integersWriter;
    }

    private BufferedWriter getFloatsWriter() throws IOException {
        if (floatsWriter == null) {
            floatsWriter = openWriter(floats);
        }
        return floatsWriter;
    }

    private BufferedWriter getStringsWriter() throws IOException {
        if (stringsWriter == null) {
            stringsWriter = openWriter(strings);
        }
        return stringsWriter;
    }

    @Override
    public void close() throws IOException {
        IOException eThrown = null;
        if (integersWriter != null) {
            try {
                integersWriter.close();
            } catch (IOException e) {
                eThrown = new IOException("Can't close output file: " + integers, e);
            }
        }
        if (floatsWriter != null) {
            try {
                floatsWriter.close();
            } catch (IOException e) {
                eThrown = new IOException("Can't close output file: " + floats, e);
            }
        }
        if (stringsWriter != null) {
            try {
                stringsWriter.close();
            } catch (IOException e) {
                eThrown = new IOException("Can't close output file: " + strings, e);
            }
        }
        if (eThrown != null) {
            throw eThrown;
        }
    }
}
