package com.github.diskursmonger.domain.statistics.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
public class IntegerStatistics {
    long amount;
    BigInteger minInt;
    BigInteger maxInt;
    BigDecimal avgInt;
    BigInteger sumInt;
}
