package com.fufu.loan.strategy;

import com.fufu.loan.domain.LoanApplicant;
import com.fufu.loan.domain.LoanApplicantResult;
import com.fufu.loan.domain.LoanApplicantScore;
import com.fufu.loan.constant.LoanConstant;
import com.fufu.loan.constant.LoanStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyTest {

    private LowScoreStrategy lowScoreStrategy;
    private HighScoreStrategy highScoreStrategy;
    private MediumScoreStrategy mediumScoreStrategy;

    @BeforeEach
    void setUp() {
        lowScoreStrategy = new LowScoreStrategy();
        highScoreStrategy = new HighScoreStrategy();
        mediumScoreStrategy = new MediumScoreStrategy();
    }


    @Test
    void whenCallLowStrategy_shouldReturnDenied() {
        LoanApplicant applicant = LoanApplicant.builder().id("11111111111")
                .monthlySalary(BigInteger.valueOf(1_000))
                .build();
        LoanApplicantResult result = lowScoreStrategy.execute(null, applicant);
        assertEquals(LoanStatus.DENIED,result.getStatus());
    }

    @Test
    void whenCallMediumStrategy_shouldReturnDenied() {
        LoanApplicant applicant = LoanApplicant.builder().id("11111111111")
                .monthlySalary(BigInteger.valueOf(1_000))
                .build();
        LoanApplicantScore score = LoanApplicantScore.builder()
                .score(400)
                .build();
        LoanApplicantResult result = mediumScoreStrategy.execute(score, applicant);
        assertEquals(LoanStatus.APPROVED,result.getStatus());
        assertEquals(LoanConstant.MIN_LOAN_AMOUNT, result.getAmount());
    }

    @Test
    void whenCallHighStrategy_shouldReturnApproved() {
        LoanApplicant applicant = LoanApplicant.builder().id("11111111111")
                .monthlySalary(BigInteger.valueOf(1_000))
                .build();
        LoanApplicantScore score = LoanApplicantScore.builder()
                .score(600)
                .build();
        LoanApplicantResult result = highScoreStrategy.execute(score, applicant);
        assertEquals(LoanStatus.APPROVED,result.getStatus());
        assertEquals(BigInteger.valueOf(4_000), result.getAmount());
    }

}
