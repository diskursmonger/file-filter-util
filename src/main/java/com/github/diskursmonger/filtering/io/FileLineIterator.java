package com.github.diskursmonger.filtering.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileLineIterator implements Iterator<String>, AutoCloseable {
    final Path path;
    final Stream<String> stream;
    final Iterator<String> it;
    FileLineIterator(Path path, Stream<String> stream) {
        this.path = path;
        this.stream = stream;
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
        return false;
    }

    @Override
    public String next() {
        return null;
    }
}
