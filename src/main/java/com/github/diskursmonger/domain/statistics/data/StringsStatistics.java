package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringsStatistics {
    long amount;
    int minLength;
    int maxLength;
}
