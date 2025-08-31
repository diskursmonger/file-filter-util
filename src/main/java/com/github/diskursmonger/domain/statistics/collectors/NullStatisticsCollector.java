package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;
import com.github.diskursmonger.domain.statistics.data.StatisticsData;
import lombok.Getter;

@Getter
public class NullStatisticsCollector implements StatisticsCollector {
    StatisticsData statisticsData;
    @Override
    public void update(String line, OutputType type) {

    }
}
