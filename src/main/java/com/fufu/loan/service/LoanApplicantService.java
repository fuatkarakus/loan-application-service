package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.LoanResponse;
import com.fufu.loan.repository.LoanApplicantRepository;
import com.fufu.loan.util.LoanConverter;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicantService implements ILoanApplicantService{

    private LoanApplicantRepository loanApplicantRepository;

    private final LoanApplicantScoreService scoreService;

    public LoanApplicantService(LoanApplicantRepository loanApplicantRepository,
                                LoanApplicantScoreService scoreService){
        this.loanApplicantRepository = loanApplicantRepository;
        this.scoreService = scoreService;
    }

    public LoanResponse process(LoanRequest request) {
        LoanApplicant applicant = LoanConverter.convert(request).build();

        saveApplicant(applicant);

        LoanApplicantScore applicantScore = scoreService.findApplicantScoreById(applicant.getId());

        LoanResponse loanResponse = LoanStrategy.execute(applicantScore.getScore(),
                        applicant.getMonthlySalary());

        return loanResponse;

    }

    public LoanApplicant saveApplicant(LoanApplicant applicant) {
       return loanApplicantRepository.save(applicant);
    }



}
