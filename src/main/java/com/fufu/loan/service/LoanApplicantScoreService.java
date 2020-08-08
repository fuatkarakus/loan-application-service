package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.repository.LoanApplicantScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicantScoreService implements ILoanApplicantScoreService{

    private final LoanApplicantScoreRepository scoreRepository;

    public LoanApplicantScoreService(LoanApplicantScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public LoanApplicantScore findApplicantScoreById(final String id) {
        return scoreRepository
                .findById(id)
                .orElse(LoanApplicantScore.builder()
                        .id(id)
                        .score(0)
                        .build());
    }

}
