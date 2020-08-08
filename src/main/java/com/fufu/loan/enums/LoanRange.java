package com.fufu.loan.enums;

import org.apache.commons.lang3.Range;

public class LoanRange {

    private LoanRange() {}

    public static final Range<Integer> LOW = Range.between(0, 500);
    public static final Range<Integer> MEDIUM = Range.between(500, 1000);
    public static final Range<Integer> HIGH = Range.between(1000, Integer.MAX_VALUE);

}
