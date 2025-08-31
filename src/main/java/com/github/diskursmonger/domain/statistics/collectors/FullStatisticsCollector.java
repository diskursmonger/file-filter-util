package com.github.diskursmonger.domain.statistics.collectors;

import com.github.diskursmonger.domain.classification.OutputType;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
public class FullStatisticsCollector extends ShortStatisticsCollector {
    @Override
    public void update(String line, OutputType type) {
        super.update(line, type);
        switch (type) {
            case INTEGER -> statisticsData.getIntegers().updateFullStatistics(new BigInteger(line));
            case FLOAT -> statisticsData.getFloats().updateFullStatistics(new BigDecimal(line));
            case STRING -> statisticsData.getStrings().updateFullStatistics(line);
        }
    }
}
