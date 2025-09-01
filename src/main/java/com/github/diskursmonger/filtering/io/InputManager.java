package com.github.diskursmonger.filtering.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class InputManager implements AutoCloseable {
    private final List<Path> inputFiles;
    private final Deque<FileLineIterator> q = new ArrayDeque<>();

    public InputManager(List<Path> inputFiles) {
        this.inputFiles = List.copyOf(inputFiles);
    }

    public void open() throws IOException {
        for (var file : inputFiles) {
            try {
                var fileLineIterator = new FileLineIterator(file);
                q.addLast(fileLineIterator);
            } catch (IOException e) {
                throw new IOException("Can't open input file: " + file, e);
            }
        }
    }

    public String readLine() throws IOException {
        while (!q.isEmpty()) {
            var it = q.pollFirst();
            if (it.hasNext()) {
                String line = it.next();
                q.addLast(it);
                return line;
            } else {
                it.close();
            }
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        IOException eThrown = null;
        while (!q.isEmpty()) {
            try {
                q.pollFirst().close();
            } catch (IOException e) {
                eThrown = new IOException("Can't close input file: ", e);
            }
        }
        if (eThrown != null) {
            throw eThrown;
        }
    }
}
