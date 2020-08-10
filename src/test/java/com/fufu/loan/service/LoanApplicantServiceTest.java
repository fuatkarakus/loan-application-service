package com.fufu.loan.service;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.repository.LoanApplicantRepository;
import com.fufu.loan.repository.LoanApplicantResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class LoanApplicantServiceTest {

    @Autowired
    LoanApplicantService applicantService;
    @MockBean
     LoanApplicantRepository loanApplicantRepository;
    @MockBean
     LoanApplicantResultRepository resultRepository;
    @MockBean
     LoanApplicantScoreService scoreService;
    @MockBean
     SmsService smsService;

    @BeforeEach
    void setup(){
        LoanApplicant applicant = LoanApplicant.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary(BigInteger.valueOf(1000))
                .phoneNumber("5312341234").build();

        Mockito.when(loanApplicantRepository.save(applicant))
                .thenReturn(applicant);
    }

    @Test
    void whenSaveApplicant_shouldReturnApplicant() {


    }


}
