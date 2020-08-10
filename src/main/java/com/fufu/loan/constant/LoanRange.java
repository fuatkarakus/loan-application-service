package com.fufu.loan.constant;

import org.apache.commons.lang3.Range;

public class LoanRange {

    private LoanRange() {}

    public static final Range<Integer> LOW = Range.between(0, 499);
    public static final Range<Integer> MEDIUM = Range.between(499, 999);
    public static final Range<Integer> HIGH = Range.between(999, Integer.MAX_VALUE);

}
