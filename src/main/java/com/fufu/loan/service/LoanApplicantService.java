package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.LoanResponse;
import com.fufu.loan.repository.LoanApplicantRepository;
import com.fufu.loan.repository.LoanApplicantResultRepository;
import com.fufu.loan.strategy.LoanStrategy;
import com.fufu.loan.strategy.LoanStrategyFactory;
import com.fufu.loan.util.LoanConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanApplicantService implements ILoanApplicantService{

    private final LoanApplicantRepository loanApplicantRepository;

    private final LoanApplicantResultRepository resultRepository;

    private final LoanApplicantScoreService scoreService;

    public LoanApplicantService(LoanApplicantRepository loanApplicantRepository,
                                LoanApplicantScoreService scoreService,
                                LoanApplicantResultRepository resultRepository){
        this.loanApplicantRepository = loanApplicantRepository;
        this.scoreService = scoreService;
        this.resultRepository = resultRepository;
    }

    public LoanResponse process(LoanRequest request) {
        LoanApplicant applicant = LoanConverter.convert(request).build();

        saveApplicant(applicant);

        LoanApplicantScore applicantScore = scoreService.findApplicantScoreById(applicant.getId());

        LoanStrategy strategy = LoanStrategyFactory.getStrategy(applicantScore.getScore(), applicant.getMonthlySalary());

        LoanApplicantResult result = strategy.execute(applicantScore, applicant);

        resultRepository.save(result);

        LoanResponse response =  LoanConverter.convert(result).build();

        return response;

    }

    public LoanApplicant saveApplicant(LoanApplicant applicant) {
       return loanApplicantRepository.save(applicant);
    }

}
