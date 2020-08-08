package com.fufu.loan.enums;

import java.math.BigInteger;

public class LoanConstant {

    private LoanConstant() { }

    public static final BigInteger INCOME_BARRIER = BigInteger.valueOf(5_000);
    public static final int LIMIT_MULTIPLIER = 4;
    public static final BigInteger MIN_LOAN_AMOUNT = BigInteger.valueOf(10_000);
}
