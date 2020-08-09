package com.fufu.loan.service;

import com.fufu.loan.enums.LoanConstant;
import com.fufu.loan.enums.LoanRange;
import com.fufu.loan.enums.LoanStatus;
import com.fufu.loan.payload.LoanResponse;

import java.math.BigInteger;

public class LoanStrategy {

    private LoanStrategy() {}

    public static LoanResponse execute(Integer score, BigInteger salary) {

        if (LoanRange.MEDIUM.contains(score) &&
                LoanConstant.INCOME_BARRIER.compareTo(salary) > 0) {

            return LoanResponse.builder()
                    .amount(LoanConstant.MIN_LOAN_AMOUNT)
                    .status(LoanStatus.APPROVED)
                    .build();

        } else if(LoanRange.HIGH.contains(score)) {

            return LoanResponse.builder()
                    .amount(salary
                            .multiply(BigInteger
                                    .valueOf(LoanConstant.LIMIT_MULTIPLIER)))
                    .status(LoanStatus.APPROVED)
                    .build();

        } else {

            return LoanResponse.builder()
                    .amount(BigInteger.ZERO)
                    .status(LoanStatus.DENIED)
                    .build();

        }

    }


}
