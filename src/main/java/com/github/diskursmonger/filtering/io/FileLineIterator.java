package com.github.diskursmonger.filtering.io;

import com.github.diskursmonger.filtering.exception.FileOperationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileLineIterator implements Iterator<String>, AutoCloseable {
    private final Stream<String> stream;
    private final Iterator<String> it;

    FileLineIterator(Path path) throws IOException {
        try {
            this.stream = Files.lines(path);
            this.it = stream.iterator();
        } catch (IOException e) {
            throw new FileOperationException("Can't open input stream: ", e);
        }
    }

    @Override
    public void close() throws IOException {
        try {
            stream.close();
        } catch (RuntimeException e) {
            throw new FileOperationException("Can't close input stream: ", e);
        }
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public String next() {
        return it.next();
    }
}
