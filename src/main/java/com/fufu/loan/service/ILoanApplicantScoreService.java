package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicantScore;

public interface ILoanApplicantScoreService {

    LoanApplicantScore findApplicantScoreById(final String id);

}
