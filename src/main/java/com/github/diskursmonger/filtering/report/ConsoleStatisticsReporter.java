package com.github.diskursmonger.filtering.report;

import com.github.diskursmonger.domain.config.StatisticsMode;
import com.github.diskursmonger.domain.statistics.collectors.StatisticsCollector;

public class ConsoleStatisticsReporter implements StatisticsReporter {
    StatisticsMode statisticsMode;

    public ConsoleStatisticsReporter(StatisticsMode statisticsMode) {
        this.statisticsMode = statisticsMode;
    }

    @Override
    public void report(StatisticsCollector statisticsCollector) {
        if (statisticsMode == StatisticsMode.NONE) {
            return;
        }
        var integers = statisticsCollector.getStatisticsData().getIntegers();
        var floats = statisticsCollector.getStatisticsData().getFloats();
        var strings = statisticsCollector.getStatisticsData().getStrings();
        if (integers.getAmount() == 0 && floats.getAmount() == 0 && strings.getAmount() == 0) {
            System.out.println("Nothing was written to files.");
            return;
        }
        if (statisticsMode == StatisticsMode.SHORT) {
            System.out.println("===SHORT STATISTICS===");
            if (integers.getAmount() != 0) {
                System.out.println("Integers amount: " + integers.getAmount());
            }
            if (floats.getAmount() != 0) {
                System.out.println("Floats amount: " + floats.getAmount());
            }
            if (strings.getAmount() != 0) {
                System.out.println("Strings amount: " + strings.getAmount());
            }
            return;
        }
        System.out.println("===FULL STATISTICS===");
        if (integers.getAmount() != 0) {
            System.out.println("_Integers_");
            System.out.println("Amount: " + integers.getAmount() + "\n" +
                    "min: " + integers.getMin() + "\n" +
                    "max: " + integers.getMax() + "\n" +
                    "sum: " + integers.getSum() + "\n" +
                    "average: " + integers.average()
            );
        }

        if (floats.getAmount() != 0) {
            System.out.println("\n_Floats_");
            System.out.println("Amount: " + floats.getAmount() + "\n" +
                    "min: " + floats.getMin() + "\n" +
                    "max: " + floats.getMax() + "\n" +
                    "sum: " + floats.getSum() + "\n" +
                    "average: " + floats.average()
            );
        }

        if (strings.getAmount() != 0) {
            System.out.println("\n_Strings_");
            System.out.println("Amount: " + strings.getAmount() + "\n" +
                    "min length: " + strings.getMinLength() + "\n" +
                    "max length: " + strings.getMaxLength()
            );
        }
    }
}
