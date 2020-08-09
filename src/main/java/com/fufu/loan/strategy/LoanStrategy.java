package com.fufu.loan.strategy;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;

public interface LoanStrategy {

    LoanApplicantResult execute(LoanApplicantScore score, LoanApplicant applicant);

}
