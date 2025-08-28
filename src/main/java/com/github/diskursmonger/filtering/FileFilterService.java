package com.github.diskursmonger.filtering;

import com.github.diskursmonger.domain.config.AppConfig;
import com.github.diskursmonger.domain.statistics.collectors.StatisticsCollectorFactory;

public class FileFilterService {
    public void run(AppConfig appConfig) {
        var statisticsCollector = StatisticsCollectorFactory.create(appConfig.statisticsMode());


    }
}
