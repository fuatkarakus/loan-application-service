package com.fufu.loan.strategy;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.enums.LoanConstant;
import com.fufu.loan.enums.LoanStatus;

public class MediumScoreStrategy implements LoanStrategy{

    @Override
    public LoanApplicantResult execute(LoanApplicantScore score, LoanApplicant applicant) {
        return LoanApplicantResult.builder()
                .amount(LoanConstant.MIN_LOAN_AMOUNT)
                .status(LoanStatus.APPROVED)
                .build();
    }

}