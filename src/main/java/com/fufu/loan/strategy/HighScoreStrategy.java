package com.fufu.loan.strategy;

import com.fufu.loan.constant.LoanConstant;
import com.fufu.loan.constant.LoanStatus;
import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;

import java.math.BigInteger;

public class HighScoreStrategy implements LoanStrategy{

    @Override
    public LoanApplicantResult execute(LoanApplicantScore score, LoanApplicant applicant) {
        return LoanApplicantResult.builder()
                .id(applicant.getId())
                .amount(multiply(applicant.getMonthlySalary()))
                .status(LoanStatus.APPROVED)
                .build();
    }

    private static BigInteger multiply(BigInteger bg) {
        return bg.multiply(BigInteger.valueOf(LoanConstant.LIMIT_MULTIPLIER));
    }
}
