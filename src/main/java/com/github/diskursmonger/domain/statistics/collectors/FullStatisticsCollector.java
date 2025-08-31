package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;

public class FullStatisticsCollector extends ShortStatisticsCollector {
    @Override
    public void update(String line, OutputType type) {
        super.update(line, type);
    }
}
