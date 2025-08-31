package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class IntegerStatistics {
    private static final int DEFAULT_SCALE = 6;
    long amount;
    BigInteger min;
    BigInteger max;
    BigInteger sum;

    public BigDecimal average() {
        if (amount == 0) {
            return BigDecimal.valueOf(0);
        }
        return new BigDecimal(sum).divide(BigDecimal.valueOf(amount), 6, BigDecimal.ROUND_HALF_UP);
    }
}
