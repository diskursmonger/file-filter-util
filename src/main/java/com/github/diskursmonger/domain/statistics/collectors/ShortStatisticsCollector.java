package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;
import com.github.diskursmonger.domain.statistics.data.StatisticsData;

public class ShortStatisticsCollector implements StatisticsCollector {
    StatisticsData statisticsData;

    public ShortStatisticsCollector() {
        this.statisticsData = new StatisticsData();
    }
    @Override
    public void update(String line, OutputType type) {
        switch (type) {
            case INTEGER -> {
            }
            case FLOAT -> {
            }
            default -> {
            }
        }
    }
}
