package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;

public interface StatisticsCollector {
    public void update(String line, OutputType type);
}
