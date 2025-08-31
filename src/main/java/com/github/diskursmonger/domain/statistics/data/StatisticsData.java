package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;

@Getter
public class StatisticsData {
    IntegerStatistics integers = new IntegerStatistics();
    FloatStatistics floats = new FloatStatistics();
    StringsStatistics strings = new StringsStatistics();
}