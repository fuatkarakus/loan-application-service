package com.fufu.loan.service;

import com.fufu.loan.constant.LoanStatus;
import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.payload.LoanRequest;
import com.fufu.loan.payload.LoanResponse;
import com.fufu.loan.repository.LoanApplicantRepository;
import com.fufu.loan.repository.LoanApplicantResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class LoanApplicantServiceTest {

    @InjectMocks
    LoanApplicantService applicantService;
    @Mock
    LoanApplicantRepository loanApplicantRepository;
    @Mock
    LoanApplicantResultRepository resultRepository;
    @Mock
    LoanApplicantScoreService scoreService;
    @Mock
    SmsService smsService;

    LoanApplicant applicant;
    LoanApplicantScore score;

    @BeforeEach
    void setup(){
        applicant = LoanApplicant.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary(BigInteger.valueOf(1000))
                .phoneNumber("5312341234").build();

        score = LoanApplicantScore.builder()
                .id("12312312312")
                .score(600)
                .build();

        Mockito.when(loanApplicantRepository.save(applicant))
                .thenReturn(applicant);

        Mockito.when(scoreService.findApplicantScoreById(applicant.getId()))
                .thenReturn(score);
    }

    @Test
    void whenSaveApplicant_shouldReturnApplicant() {
        assertEquals(applicant , applicantService.save(applicant));
    }

    @Test
    void whenLoanRequest_shouldProcessSucceed() {
        LoanRequest request = LoanRequest.builder()
                .id("12312312312")
                .name("fuat")
                .surname("kara")
                .monthlySalary("1000")
                .phoneNumber("5312341234").build();

        LoanResponse response = applicantService.process(request);

        assertEquals(LoanStatus.APPROVED, response.getStatus());
    }



}
