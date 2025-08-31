package com.github.diskursmonger.filtering.report;

import com.github.diskursmonger.domain.statistics.collectors.StatisticsCollector;

public interface StatisticsReporter  {
    void report(StatisticsCollector statisticsCollector);
}
