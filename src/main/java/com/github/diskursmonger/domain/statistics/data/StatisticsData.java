package com.github.diskursmonger.domain.statistics.data;

import com.github.diskursmonger.domain.statistics.data.FloatStatistics;
import com.github.diskursmonger.domain.statistics.data.IntegerStatistics;
import com.github.diskursmonger.domain.statistics.data.StringsStatistics;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsData {
    IntegerStatistics integers;
    FloatStatistics floats;
    StringsStatistics strings;
}