package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.repository.LoanApplicantScoreRepository;
import com.fufu.loan.util.Utils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @EventListener(ApplicationReadyEvent.class)
    public void initScoreData() {
        List<LoanApplicantScore> scoreList =  Utils.getInitialScoreData();
        scoreRepository.saveAll(scoreList);
    }

}
