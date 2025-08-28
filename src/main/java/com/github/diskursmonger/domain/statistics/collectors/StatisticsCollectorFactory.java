package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.config.StatisticsMode;

public class StatisticsCollectorFactory {
    public static StatisticsCollector create(StatisticsMode mode) {
        return (mode == StatisticsMode.SHORT) ? new ShortStatisticsCollector() :
                (mode == StatisticsMode.FULL) ? new FullStatisticsCollector() : new NullStatisticsCollector();
    }
}
