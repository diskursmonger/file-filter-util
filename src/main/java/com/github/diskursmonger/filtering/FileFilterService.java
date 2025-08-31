package com.github.diskursmonger.filtering;

import com.github.diskursmonger.domain.classification.OutputType;
import com.github.diskursmonger.domain.classification.OutputTypeClassifier;
import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.statistics.collectors.StatisticsCollectorFactory;
import com.github.diskursmonger.filtering.io.InputManager;
import com.github.diskursmonger.filtering.io.OutputManager;

import java.io.IOException;

public class FileFilterService {
    public void run(AppConfig appConfig) throws IOException {
        var statisticsCollector = StatisticsCollectorFactory.create(appConfig.statisticsMode());

        try (InputManager inputManager = new InputManager(appConfig.inputFiles());
            OutputManager outputManager = new OutputManager(appConfig)) {
            inputManager.open();

            String line;
            while ((line = inputManager.readLine()) != null) {
                OutputType type = OutputTypeClassifier.classify(line);
                outputManager.write(line, type);
                statisticsCollector.update(line, type);
            }
        }
    }
}
