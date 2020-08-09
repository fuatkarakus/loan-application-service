package com.fufu.loan.strategy;

import com.fufu.loan.enums.LoanConstant;
import com.fufu.loan.enums.LoanRange;

import java.math.BigInteger;

public class LoanStrategyFactory {

    private LoanStrategyFactory() {}

    public static LoanStrategy getStrategy(Integer score, BigInteger salary) {

        if (LoanRange.MEDIUM.contains(score) && isSalaryUnderBarrier(salary)) {

            return new MediumScoreStrategy();

        } else if(LoanRange.HIGH.contains(score)) {

            return new HighScoreStrategy();

        } else {

            return new LowScoreStrategy();
        }
    }

    private static boolean isSalaryUnderBarrier(BigInteger salary) {
        return LoanConstant.INCOME_BARRIER.compareTo(salary) > 0;
    }

}
