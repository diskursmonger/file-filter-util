package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class FloatStatistics {
    private static final int DEFAULT_SCALE = 6;
    long amount;
    BigDecimal min;
    BigDecimal max;
    BigDecimal sum = BigDecimal.ZERO;

    public BigDecimal average() {
        if (amount == 0) {
            return BigDecimal.ZERO;
        }
        return sum.divide(BigDecimal.valueOf(amount), DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    public void incrementAmount() {
        amount++;
    }

    public void updateFullStatistics(BigDecimal value) {
        sum = sum.add(value);
        if (min == null || value.compareTo(min) < 0) {
            min = value;
        }
        if (max == null || value.compareTo(max) > 0) {
            max = value;
        }
    }
}
