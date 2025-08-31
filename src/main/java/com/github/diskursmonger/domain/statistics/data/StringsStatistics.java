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
        if (minLength > value.length()) {
            minLength = value.length();
        }
        if (maxLength < value.length()) {
            maxLength = value.length();
        }
    }
}
