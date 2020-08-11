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

    private final SmsService smsService;

    public LoanApplicantService(LoanApplicantRepository loanApplicantRepository,
                                LoanApplicantScoreService scoreService,
                                LoanApplicantResultRepository resultRepository,
                                SmsService smsService){
        this.loanApplicantRepository = loanApplicantRepository;
        this.scoreService = scoreService;
        this.resultRepository = resultRepository;
        this.smsService = smsService;
    }

    public LoanResponse process(LoanRequest request) {
        // convert request to entity
        LoanApplicant applicant = LoanConverter.convertRequest(request).build();

        // save request
        save(applicant);

        // find score
        LoanApplicantScore applicantScore = scoreService.findApplicantScoreById(applicant.getId());

        // get strategy by score
        LoanStrategy strategy = LoanStrategyFactory.getStrategy(applicantScore.getScore(),
                applicant.getMonthlySalary());

        // execute the result of application
        LoanApplicantResult result = strategy.execute(applicantScore, applicant);

        // save result of application
        resultRepository.save(result);

        LoanResponse response =  LoanConverter.convertResult(result).build();

        // send sms
        smsService.sendSMS(applicant);

        return response;

    }

    public LoanApplicant save(LoanApplicant applicant) {
       return loanApplicantRepository.save(applicant);
    }

}
