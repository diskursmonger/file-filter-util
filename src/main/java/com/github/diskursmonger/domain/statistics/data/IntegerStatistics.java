package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
public class IntegerStatistics {
    private static final int DEFAULT_SCALE = 6;
    long amount;
    BigInteger min;
    BigInteger max;
    BigInteger sum = BigInteger.ZERO;

    public BigDecimal average() {
        if (amount == 0) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(sum).divide(BigDecimal.valueOf(amount), 6, BigDecimal.ROUND_HALF_UP);
    }

    public void incrementAmount() {
        amount++;
    }

    public void updateFullStatistics(BigInteger value) {
        sum = sum.add(value);
        if (min == null || value.compareTo(min) < 0) {
            min = value;
        }
        if (max == null || value.compareTo(max) > 0) {
            max = value;
        }
    }
}
