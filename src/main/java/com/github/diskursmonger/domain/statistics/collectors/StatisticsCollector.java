package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;
import com.github.diskursmonger.domain.statistics.data.StatisticsData;

public interface StatisticsCollector {
    void update(String line, OutputType type);
    StatisticsData getStatisticsData();
}
