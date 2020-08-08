package com.fufu.loan.service;

import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.repository.LoanApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final LoanApplicantRepository loanApplicantRepository;

    public UserService(LoanApplicantRepository loanApplicantRepository){
        this.loanApplicantRepository = loanApplicantRepository;
    }

    public void handleLoan(LoanRequest request) {

    }

}
