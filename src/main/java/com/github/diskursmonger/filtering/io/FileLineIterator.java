package com.github.diskursmonger.filtering.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileLineIterator implements Iterator<String>, AutoCloseable {
    private final Stream<String> stream;
    private final Iterator<String> it;

    FileLineIterator(Path path) throws IOException {
        this.stream = Files.lines(path);
        this.it = stream.iterator();
    }

    @Override
    public void close() throws IOException {
        try {
            stream.close();
        } catch (RuntimeException e) {
            throw new IOException("Can't close stream: ", e);
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
