package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;


@Getter
public class StringsStatistics {
    long amount;
    int minLength;
    int maxLength;

    public void incrementAmount() {
        amount++;
    }

    public void updateFullStatistics(String value) {
        if (minLength == 0 || minLength > value.length()) {
            minLength = value.length();
        }
        if (maxLength == 0 || maxLength < value.length()) {
            maxLength = value.length();
        }
    }
}
