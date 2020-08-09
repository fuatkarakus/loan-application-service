package com.fufu.loan.strategy;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.enums.LoanStatus;

import java.math.BigInteger;

public class LowScoreStrategy implements LoanStrategy {

    @Override
    public LoanApplicantResult execute(LoanApplicantScore score, LoanApplicant applicant) {
        return LoanApplicantResult.builder()
                .amount(BigInteger.ZERO)
                .status(LoanStatus.DENIED)
                .build();
    }
}
