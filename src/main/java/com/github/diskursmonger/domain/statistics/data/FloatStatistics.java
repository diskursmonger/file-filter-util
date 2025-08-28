package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FloatStatistics {
    long amount;
    BigDecimal minFloat;
    BigDecimal maxFloat;
    BigDecimal avgFloat;
    BigDecimal sumFloat;
}
