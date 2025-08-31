package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;

public class NullStatisticsCollector implements StatisticsCollector {
    @Override
    public void update(String line, OutputType type) {

    }
}
