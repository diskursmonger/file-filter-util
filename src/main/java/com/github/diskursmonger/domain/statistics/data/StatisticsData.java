package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsData {
    IntegerStatistics integers;
    FloatStatistics floats;
    StringsStatistics strings;
}