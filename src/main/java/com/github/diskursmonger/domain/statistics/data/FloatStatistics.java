package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FloatStatistics {
    private static final int DEFAULT_SCALE = 6;
    long amount;
    BigDecimal min;
    BigDecimal max;
    BigDecimal sum;

    public BigDecimal average() {
        if (amount == 0) {
            return BigDecimal.valueOf(0);
        }
        return sum.divide(BigDecimal.valueOf(amount), DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }
}
